package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description:默认已定义好的bean工厂
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:33
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry,
        ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    /**
     * 向注册表中注册 BeanDefinition
     * <p>
     * 实现自 BeanDefinitionRegistry 方法
     *
     * @param beanName       bean名称
     * @param beanDefinition bean定义
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 判断是否包含指定名称的BeanDefinition
     * <p>
     * 实现自 BeanDefinitionRegistry接口
     *
     * @param beanName 名称
     * @return /
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 按照类型返回 Bean 所有符合的实例
     * <p>
     * 实现自 ListableBeanFactory 接口
     *
     * @param type clazz
     * @param <T>  泛型
     * @return 对应类型的所有实例
     * @throws BeansException /
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class<T> beanClass = (Class<T>) beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    /**
     * Return the names of all beans defined in this registry.
     *
     * @return 注册表中所有的Bean名称
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    /**
     * 获取bean定义
     *
     * @param beanName bean名称
     * @return bean定义
     * @throws BeansException bean异常
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }
}

