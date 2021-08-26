package cn.duktig.springframework.context.support;

import cn.duktig.springframework.beans.BeansException;

/**
 * description: 应用上下文实现类
 * <p>
 * 是具体对外给用户提供的应用上下文方法
 *
 * @author RenShiWei
 * Date: 2021/8/26 9:20
 **/
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations /
     * @throws BeansException /
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[] {configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations /
     * @throws BeansException /
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        //调用父类 AbstractApplicationContext 方法 刷新bean工厂中 bean对象，并提供扩展机制的支持
        refresh();
    }

    /**
     * 获取配置资源的所有位置
     * 从入口上下文类，拿到配置信息的地址描述
     * <p>
     * 继承自 AbstractXmlApplicationContext
     *
     * @return 配置资源的所有位置信息
     */
    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}

