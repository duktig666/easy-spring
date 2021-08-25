package cn.duktig.springframework.beans.factory;

import cn.duktig.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description:Bean 工厂
 * <p>
 * 实现创建bean定义和获取bean的功能
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:09
 **/
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}

