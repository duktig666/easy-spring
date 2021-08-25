package cn.duktig.springframework.test;

import cn.duktig.springframework.beans.factory.BeanFactory;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * description: 测试 实现的一个简单bean容器的功能
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:59
 **/
public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}

