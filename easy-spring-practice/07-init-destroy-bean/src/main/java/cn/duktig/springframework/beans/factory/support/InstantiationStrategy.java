package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * description:实例化策略接口
 *
 * @author RenShiWei
 * Date: 2021/8/25 15:55
 **/
public interface InstantiationStrategy {

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
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;

}
