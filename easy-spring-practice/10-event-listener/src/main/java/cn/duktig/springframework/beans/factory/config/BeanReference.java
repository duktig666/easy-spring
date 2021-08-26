package cn.duktig.springframework.beans.factory.config;

/**
 * description:Bean 的引用
 *
 * @author RenShiWei
 * Date: 2021/8/25 17:39
 **/
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}

