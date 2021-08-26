package cn.duktig.springframework.beans.factory;

import cn.duktig.springframework.beans.BeansException;

/**
 * description:Bean 工厂
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:09
 **/
public interface BeanFactory {

    /**
     * 获取bean对象
     *
     * @param beanName bean名称
     * @return bean对象
     * @throws BeansException bean异常
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 获取带构造器参数生成的 bean对象
     *
     * @param beanName bean名称
     * @param args     参数
     * @return bean对象
     * @throws BeansException bean异常
     */
    Object getBean(String beanName, Object... args) throws BeansException;

    /**
     * 获取带构造器参数生成的 bean对象
     *
     * @param beanName     bean名称
     * @param requiredType 类型
     * @return bean对象
     * @throws BeansException bean异常
     */
    <T> T getBean(String beanName, Class<T> requiredType) throws BeansException;

}

