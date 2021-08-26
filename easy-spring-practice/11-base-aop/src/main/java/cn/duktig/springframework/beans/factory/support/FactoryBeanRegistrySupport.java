package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description:FactoryBean 注册服务 抽象类
 * <p>
 * ①主要处理的就是关于 FactoryBean 此类对象的注册操作，之所以放到这样一个单独的类里，
 * 就是希望做到不同领域模块下只负责各自需要完成的功能，避免因为扩展导致类膨胀到难以维护
 * ②定义了缓存操作 factoryBeanObjectCache，用于存放单例类型的对象，避免重复创建
 *
 * @author RenShiWei
 * Date: 2021/8/26 16:32
 **/
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    /**
     * 由factory bean创建的单例对象的缓存
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>(16);

    /**
     * 从缓存中获取 FactoryBean 对象
     *
     * @param beanName 对象名称
     * @return 缓存中的 FactoryBean对象
     */
    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    /**
     * 具体的获取 FactoryBean#getObject() 方法
     * <p>
     * 因为既有缓存的处理也有对象的获取，所以额外提供了 getObjectFromFactoryBean 进行逻辑包装，
     * 这部分的操作方式是不和日常做的业务逻辑开发非常相似：从Redis取数据，如果为空就从数据库获取并写入Redis
     *
     * @param factory  /
     * @param beanName /
     * @return /
     */
    protected Object getObjectFromFactoryBean(FactoryBean<?> factory, String beanName) {
        if (factory.isSingleton()) {
            //单例对象先从缓存中获取，若没有则从工厂中获取
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            // 非单例对象 直接从工厂中获取
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    /**
     * 从工厂中 获取bean对象
     *
     * @param factory  工厂
     * @param beanName /
     * @return /
     */
    private Object doGetObjectFromFactoryBean(final FactoryBean<?> factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}

