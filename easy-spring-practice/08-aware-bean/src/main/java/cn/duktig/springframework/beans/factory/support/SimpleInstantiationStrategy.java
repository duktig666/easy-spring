package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * description: JDK代理 实例化对象 策略
 *
 * @author RenShiWei
 * Date: 2021/8/25 15:58
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 实例化对象
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名称
     * @param ctor           构造器
     * @param args           构造器参数
     * @return 实例化的bean对象
     * @throws BeansException bean异常
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException {
        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }

}

