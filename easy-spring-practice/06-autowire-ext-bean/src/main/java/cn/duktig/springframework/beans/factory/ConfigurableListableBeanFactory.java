package cn.duktig.springframework.beans.factory;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.beans.factory.config.BeanPostProcessor;
import cn.duktig.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * description: 可配置/修改bean 的工厂
 * <p>
 * 用于分析和修改bean定义，并预实例化单例
 *
 * @author RenShiWei
 * Date: 2021/8/25 20:37
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory,
        ConfigurableBeanFactory {

    /**
     * 获取bean定义
     *
     * @param beanName bean名称
     * @return bean定义
     * @throws BeansException /
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化单例Bean对象
     *
     * @throws BeansException /
     */
    void preInstantiateSingletons() throws BeansException;

    /**
     * 注册所有的BeanPostProcessors 方法
     *
     * @param beanPostProcessor /
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
