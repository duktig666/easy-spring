package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description:默认的 单例注册接口
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:16
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    /**
     * 获取单例对象
     *
     * @param beanName bean名称
     * @return 单例对象
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 注册单例对象
     *
     * @param beanName        bean名称
     * @param singletonObject 单例对象
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}

