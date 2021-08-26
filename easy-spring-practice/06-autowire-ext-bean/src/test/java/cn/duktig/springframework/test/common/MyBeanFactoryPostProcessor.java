package cn.duktig.springframework.test.common;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.PropertyValue;
import cn.duktig.springframework.beans.PropertyValues;
import cn.duktig.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * description: 自定义 bean定义加载完成后 实例化前  扩展机制
 *
 * @author RenShiWei
 * Date: 2021/8/26 9:35
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory bean工厂
     * @throws BeansException /
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        //bean定义加载完成后 实例化前 将公司改为 字节跳动测试
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}

