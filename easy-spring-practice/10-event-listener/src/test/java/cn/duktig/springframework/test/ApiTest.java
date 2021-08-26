package cn.duktig.springframework.test;

import cn.duktig.springframework.context.support.ClassPathXmlApplicationContext;
import cn.duktig.springframework.test.event.CustomEvent;
import org.junit.Test;

/**
 * description:测试 【基于观察者实现，容器事件和事件监听器】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试事件监听
     */
    @Test
    public void testEvent() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}

