package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.core.io.Resource;
import cn.duktig.springframework.core.io.ResourceLoader;

/**
 * description: Bean定义 读取资源 接口
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:35
 **/
public interface BeanDefinitionReader {

    /**
     * 得到 bean定义 的注册器
     * 为 loadBeanDefinitions 服务
     *
     * @return bean定义 的注册器
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取 资源加载器
     * 为 loadBeanDefinitions 服务
     *
     * @return 资源加载器
     */
    ResourceLoader getResourceLoader();

    /**
     * 从 Resource 中加载 bean的定义
     *
     * @param resource /
     * @throws BeansException /
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 从 Resource列表 中加载 bean的定义
     *
     * @param resources /
     * @throws BeansException /
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 从 指定位置 加载 bean的定义
     *
     * @param location /
     * @throws BeansException /
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 从 指定位置 加载 bean的定义
     *
     * @param locations /
     * @throws BeansException /
     */
    void loadBeanDefinitions(String... locations) throws BeansException;

}

