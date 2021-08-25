package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.BeanFactory;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 * description:抽象bean工厂 其中一些抽象方法由子类实现
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:21
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

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
     * 获取bean对象的真实方法
     *
     * @param beanName bean名称
     * @param args     构造器参数
     * @return bean对象
     */
    protected Object doGetBean(final String beanName, final Object[] args) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
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

}

