package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.FactoryBean;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.beans.factory.config.BeanPostProcessor;
import cn.duktig.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.duktig.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * description:抽象bean工厂 其中一些抽象方法由子类实现
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:21
 **/
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * 获取bean对象
     *
     * @param beanName bean名称
     * @return bean对象
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    /**
     * 获取bean对象
     *
     * @param beanName bean名称
     * @param args     构造器参数
     * @return bean对象
     */
    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    /**
     * 获取带构造器参数生成的 bean对象
     * TODO:@RenShiWei 2021/8/25 description: 可能存在问题
     *
     * @param beanName     bean名称
     * @param requiredType 类型
     * @return bean对象
     * @throws BeansException bean异常
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) getBean(beanName);
    }

    /**
     * 获取bean对象的真实方法
     *
     * @param beanName bean名称
     * @param args     构造器参数
     * @return bean对象
     */
    @SuppressWarnings("unchecked")
    protected <T> T doGetBean(final String beanName, final Object[] args) {
        Object sharedInstance = getSingleton(beanName);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, beanName);
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    /**
     * 获取 FactoryBean 的操作
     *
     * @param beanInstance /
     * @param beanName     /
     * @return /
     */
    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (! (beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = this.getCachedObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = this.getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }


    /**
     * 获取bean定义
     *
     * @param beanName bean名称
     * @return bean定义
     * @throws BeansException bean异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建bean对象
     *
     * @param beanName       bean名称
     * @param beanDefinition bean定义
     * @param args           构造器参数
     * @return 创建后的bean对象
     * @throws BeansException bean异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    /**
     * 增加 bean实例化后 的扩展处理
     *
     * @param beanPostProcessor /
     */
    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    /**
     * 获得当前的类加载器
     *
     * @return 当前的类加载器
     */
    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

}

