package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;

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
        //反射 创建bean对象 （目前未考虑到 有参构造的情况）
        Object bean = createBeanInstance(beanDefinition, beanName, args);
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

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}

