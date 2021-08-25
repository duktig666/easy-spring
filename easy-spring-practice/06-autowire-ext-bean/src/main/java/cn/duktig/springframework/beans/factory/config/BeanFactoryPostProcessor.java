package cn.duktig.springframework.beans.factory.config;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * description: Spring 框架组建提供的容器扩展机制
 * <p>
 * 允许在 Bean 对象注册后但未实例化之前，对 Bean 的定义信息 BeanDefinition 执行修改操作
 *
 * @author RenShiWei
 * Date: 2021/8/25 21:45
 **/
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory bean工厂
     * @throws BeansException /
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}

