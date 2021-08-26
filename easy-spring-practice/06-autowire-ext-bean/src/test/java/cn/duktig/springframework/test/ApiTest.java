package cn.duktig.springframework.test;

import cn.duktig.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.duktig.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.duktig.springframework.context.support.ClassPathXmlApplicationContext;
import cn.duktig.springframework.test.bean.UserService;
import cn.duktig.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.duktig.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * description:测试 【实现应用上下文，自动识别、资源加载、扩展机制】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试 不用应用上下文 手动使用扩展机制
     */
    @Test
    public void testBeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    /**
     * 使用应用上下文 自动配置 扩展机制
     */
    @Test
    public void testXml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath" +
                ":springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}

