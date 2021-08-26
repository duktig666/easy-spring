package cn.duktig.springframework.test;

import cn.duktig.springframework.context.support.ClassPathXmlApplicationContext;
import cn.duktig.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * description:测试 【定义标记类型Aware接口，实现感知容器对象】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试 aware 感知bean对象
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

        System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
    }


}

