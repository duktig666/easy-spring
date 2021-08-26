package cn.duktig.springframework.beans.factory.config;

import cn.duktig.springframework.beans.BeansException;

/**
 * description:Spring 提供的扩展机制
 * <p>
 * BeanPostProcessor 是在 Bean 对象实例化之后修改 Bean 对象，也可以替换 Bean 对象。
 * 与后面要实现的 AOP 有着密切的关系。
 *
 * @author RenShiWei
 * Date: 2021/8/25 21:46
 **/
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean     /
     * @param beanName /
     * @return 实例化前可能被修改的bean对象
     * @throws BeansException /
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean     /
     * @param beanName /
     * @return 实例化后可能被修改的bean对象
     * @throws BeansException /
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
