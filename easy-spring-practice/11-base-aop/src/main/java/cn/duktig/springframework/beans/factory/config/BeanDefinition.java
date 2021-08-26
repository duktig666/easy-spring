package cn.duktig.springframework.beans.factory.config;

import cn.duktig.springframework.beans.PropertyValues;

/**
 * description:Bean对象的定义
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:06
 **/
public class BeanDefinition {

    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    /** bean的 Class对象 */
    private Class<?> beanClass;
    /** bean的属性列表 */
    private PropertyValues propertyValues;
    /** bean初始化的方法名 */
    private String initMethodName;
    /** bean销毁的方法名 */
    private String destroyMethodName;

    /** 当前对象的 作用域（默认单例） */
    private String scope = SCOPE_SINGLETON;

    /** 用于把从 spring.xml 中解析到的 Bean 对象作用范围填充到属性 */
    private boolean singleton = true;

    /** 用于把从 spring.xml 中解析到的 Bean 对象作用范围填充到属性 */
    private boolean prototype = false;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return singleton;
    }

    public boolean isPrototype() {
        return prototype;
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

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}

