package cn.duktig.springframework.beans.factory.config;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.BeanFactory;

/**
 * description: 可自动装配的 Bean工厂 接口
 * <p>
 * 自动装配现有的bean实例
 *
 * @author RenShiWei
 * Date: 2021/8/25 20:40
 **/
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean 已经存在的Bean对象
     * @param beanName     bean名称
     * @return 实例化前的bean对象
     * @throws BeansException /
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean 已经存在的Bean对象
     * @param beanName     bean名称
     * @return 实例化后的bean对象
     * @throws BeansException /
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
