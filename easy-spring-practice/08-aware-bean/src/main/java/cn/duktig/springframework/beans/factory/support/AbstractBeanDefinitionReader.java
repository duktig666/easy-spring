package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.io.DefaultResourceLoader;
import cn.duktig.springframework.io.ResourceLoader;

/**
 * description:Bean定义 读取资源 抽象类
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:42
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}

