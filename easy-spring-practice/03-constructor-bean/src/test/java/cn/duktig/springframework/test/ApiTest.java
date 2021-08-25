package cn.duktig.springframework.test;

import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.duktig.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.duktig.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * description:测试 【基于Cglib实现含构造函数的类实例化策略】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试带有构造参数的方式实例化bean
     */
    @Test
    public void testBeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "duktig");
        userService.queryUserInfo();
    }

    /**
     * 测试无参构造器 创建对象实例 未设置好服务名，所以输出null
     */
    @Test
    public void testNewInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    /**
     * 测试有参构造器 创建对象实例 输出name
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("duktig");
        System.out.println(userService);
    }

    /**
     * 测试调用有参构造器创建对象实例
     */
    @Test
    public void testParameterType() throws Exception {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[1];
        Constructor<UserService> declaredConstructor =
                beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("duktig");
        System.out.println(userService);
    }

    /**
     * 测试根据参数类型和数量，调用指定的构造器创建对象实例
     */
    @Test
    public void testParameterTypes() throws Exception {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Object[] args = {"duktig"};
        Constructor<?> constructor = null;
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }

        Constructor<UserService> declaredConstructor =
                beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance(args);
        System.out.println(userService);
    }

    /**
     * 测试Cglib代理
     */
    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[] {String.class}, new Object[] {"duktig"});
        System.out.println(obj);
    }

}

