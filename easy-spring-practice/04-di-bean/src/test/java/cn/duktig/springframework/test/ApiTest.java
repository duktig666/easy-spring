package cn.duktig.springframework.test;

import cn.duktig.springframework.beans.PropertyValue;
import cn.duktig.springframework.beans.PropertyValues;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.beans.factory.config.BeanReference;
import cn.duktig.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.duktig.springframework.test.bean.UserDao04;
import cn.duktig.springframework.test.bean.UserService04;
import org.junit.Test;

/**
 * description:测试 【实现Bean对象注入属性和依赖】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试 实现Bean对象注入属性
     */
    @Test
    public void testBeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao04.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService04.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService04 userService = (UserService04) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}

