package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.PropertyValue;
import cn.duktig.springframework.beans.PropertyValues;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Constructor;

/**
 * description:可自动装配的抽象工厂
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:28
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /** 现在默认使用的Cglib的方式，正确是根据不同的情况自动进行选择 */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 创建bean对象
     *
     * @param beanName       bean名称
     * @param beanDefinition bean定义
     * @param args           构造器参数
     * @return 创建后的bean对象
     * @throws BeansException bean异常
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        //反射 创建bean对象
        bean = this.createBeanInstance(beanDefinition, beanName, args);
        // 给 Bean 填充属性
        this.applyPropertyValues(beanName, bean, beanDefinition);
        //注册单例对象
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 创建bean对象实例（支持有参构造器创建）
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名称
     * @param args           构造器参数
     * @return bean对象实例
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        //？ 只判断参数个数一致，能确定一个构造器吗？ 万一类型不同
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        //使用分配好的策略进行创建对象实例
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}

