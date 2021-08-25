package cn.duktig.springframework.beans.factory;

/**
 * description:Bean 工厂
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:09
 **/
public interface BeanFactory {

    /**
     * 获取bean对象
     *
     * @param beanName bean名称
     * @return bean对象
     */
    Object getBean(String beanName);

}

