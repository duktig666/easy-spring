package cn.duktig.springframework.beans.factory;

import cn.duktig.springframework.beans.BeansException;

import java.util.Map;

/**
 * description: 枚举所有bean的工厂
 * <p>
 * 可以枚举所有bean实例，而不是尝试bean查找按客户要求逐个命名。
 *
 * @author RenShiWei
 * Date: 2021/8/25 20:38
 **/
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 所有符合的实例
     *
     * @param type clazz
     * @param <T>  泛型
     * @return 对应类型的所有实例
     * @throws BeansException /
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     * <p>
     *
     * @return 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
