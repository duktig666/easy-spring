package cn.duktig.springframework.test.common;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.config.BeanPostProcessor;
import cn.duktig.springframework.test.bean.UserService;

/**
 * description: 自定义 bean 实例化前后 扩展机制
 *
 * @author RenShiWei
 * Date: 2021/8/26 9:36
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean     /
     * @param beanName /
     * @return 实例化前可能被修改的bean对象
     * @throws BeansException /
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            // bean初始化前 将工作地址改为 北京
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean     /
     * @param beanName /
     * @return 实例化后可能被修改的bean对象
     * @throws BeansException /
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}

