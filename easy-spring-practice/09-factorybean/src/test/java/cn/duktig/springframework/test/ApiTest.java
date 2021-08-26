package cn.duktig.springframework.test;

import cn.duktig.springframework.context.support.ClassPathXmlApplicationContext;
import cn.duktig.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * description:测试 【关于Bean对象作用域以及FactoryBean的实现和使用】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试 单例/原型 模式是否生效
     */
    @Test
    public void testPrototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        System.out.println(userService01 == userService02);
    }

    /**
     * 测试  FactoryBea 定制 IUserDao的bean创建过程
     */
    @Test
    public void testFactoryBean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}

