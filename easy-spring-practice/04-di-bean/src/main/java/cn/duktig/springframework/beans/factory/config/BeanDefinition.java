package cn.duktig.springframework.beans.factory.config;

/**
 * description:Bean对象的定义
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:06
 **/
public class BeanDefinition {

    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}

