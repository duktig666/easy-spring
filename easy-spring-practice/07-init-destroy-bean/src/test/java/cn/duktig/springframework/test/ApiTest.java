package cn.duktig.springframework.test;

import cn.duktig.springframework.context.support.ClassPathXmlApplicationContext;
import cn.duktig.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * description:测试 【向虚拟机注册钩子，实现Bean对象的初始化和销毁方法】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试 初始化和销毁 方法
     */
    @Test
    public void testXml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    /**
     * 测试 虚拟机的钩子
     */
    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }

}

