package cn.duktig.springframework.beans.factory.config;

import cn.duktig.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * description:可配置的 Bean 工厂
 * <p>
 * 单例模式和原型模式 的选择
 *
 * @author RenShiWei
 * Date: 2021/8/25 20:35
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 增加 bean实例化后 的扩展处理
     *
     * @param beanPostProcessor /
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

}
