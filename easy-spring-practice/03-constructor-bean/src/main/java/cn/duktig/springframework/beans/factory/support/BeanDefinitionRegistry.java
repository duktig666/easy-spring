package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.factory.config.BeanDefinition;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:35
 **/
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName       bean名称
     * @param beanDefinition bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
