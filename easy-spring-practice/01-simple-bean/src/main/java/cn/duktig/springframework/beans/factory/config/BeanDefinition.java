package cn.duktig.springframework.beans.factory.config;

/**
 * description:Bean对象的定义
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:06
 **/
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
