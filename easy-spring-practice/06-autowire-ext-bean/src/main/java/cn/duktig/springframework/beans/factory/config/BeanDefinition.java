package cn.duktig.springframework.beans.factory.config;

import cn.duktig.springframework.beans.PropertyValues;

/**
 * description:Bean对象的定义
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:06
 **/
public class BeanDefinition {

    /** bean的 Class对象 */
    private Class<?> beanClass;

    /** bean的属性列表 */
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}

