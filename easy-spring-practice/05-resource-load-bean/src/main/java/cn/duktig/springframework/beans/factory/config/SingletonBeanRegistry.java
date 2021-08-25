package cn.duktig.springframework.beans.factory.config;

/**
 * description:单例注册接口
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:15
 **/
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     *
     * @param beanName bean名称
     * @return 单例对象
     */
    Object getSingleton(String beanName);

}
