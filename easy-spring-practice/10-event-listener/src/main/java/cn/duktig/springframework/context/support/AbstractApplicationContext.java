package cn.duktig.springframework.context.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.duktig.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.duktig.springframework.beans.factory.config.BeanPostProcessor;
import cn.duktig.springframework.context.ApplicationEvent;
import cn.duktig.springframework.context.ApplicationListener;
import cn.duktig.springframework.context.ConfigurableApplicationContext;
import cn.duktig.springframework.context.event.ApplicationEventMulticaster;
import cn.duktig.springframework.context.event.ContextClosedEvent;
import cn.duktig.springframework.context.event.ContextRefreshedEvent;
import cn.duktig.springframework.context.event.SimpleApplicationEventMulticaster;
import cn.duktig.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * description: 抽象应用上下文
 * <p>
 * 继承 DefaultResourceLoader 是为了处理 spring.xml 配置资源的加载
 *
 * @author RenShiWei
 * Date: 2021/8/25 21:52
 **/
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6. 初始化事件发布者
        initApplicationEventMulticaster();

        // 7. 注册事件监听器
        registerListeners();

        // 8. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

        // 9. 发布容器刷新完成事件
        finishRefresh();
    }

    /**
     * 刷新 bean 工厂
     *
     * @throws BeansException /
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 获取 Bean工厂
     *
     * @return Bean工厂
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 执行beanFactory 所有bean对象实例化前的 扩展方法
     *
     * @param beanFactory /
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap =
                beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 注册所有的BeanPostProcessors 方法
     *
     * @param beanFactory /
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    /**
     * 初始化事件发布者，主要用于实例化一个 SimpleApplicationEventMulticaster，这是一个事件广播器
     */
    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * Return the names of all beans defined in this registry.
     * <p>
     * 实现自 ListableBeanFactory -> BeanFactory
     *
     * @return 返回注册表中所有的Bean名称
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 获取bean对象
     * <p>
     * 实现自 BeanFactory 接口
     *
     * @param beanName bean名称
     * @return bean对象
     * @throws BeansException bean异常
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    /**
     * 获取带构造器参数生成的 bean对象
     * <p>
     * 实现自 BeanFactory 接口
     *
     * @param beanName bean名称
     * @param args     参数
     * @return bean对象
     * @throws BeansException bean异常
     */
    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    /**
     * 获取带构造器参数生成的 bean对象
     * <p>
     * 实现自 BeanFactory 接口
     *
     * @param beanName     bean名称
     * @param requiredType 类型
     * @return bean对象
     * @throws BeansException bean异常
     */
    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(beanName, requiredType);
    }

    /**
     * 注册虚拟机钩子的方法，调用 销毁bean 方法
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        // 发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));

        // 执行销毁单例bean的销毁方法
        getBeanFactory().destroySingletons();
    }

}

