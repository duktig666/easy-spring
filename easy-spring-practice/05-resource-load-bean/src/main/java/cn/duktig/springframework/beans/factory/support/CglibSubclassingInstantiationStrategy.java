package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * description:Cglib代理 实例化对象 策略
 *
 * @author RenShiWei
 * Date: 2021/8/25 16:01
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {


    /**
     * 实例化对象
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名称
     * @param ctor           构造器
     * @param args           构造器参数
     * @return 实例化的bean对象
     * @throws BeansException bean异常
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }

}

