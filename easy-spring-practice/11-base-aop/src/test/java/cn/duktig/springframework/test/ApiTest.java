package cn.duktig.springframework.test;

import cn.duktig.springframework.aop.AdvisedSupport;
import cn.duktig.springframework.aop.TargetSource;
import cn.duktig.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.duktig.springframework.aop.framework.Cglib2AopProxy;
import cn.duktig.springframework.aop.framework.JdkDynamicAopProxy;
import cn.duktig.springframework.test.bean.IUserService;
import cn.duktig.springframework.test.bean.UserService;
import cn.duktig.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * description:测试 【基于观察者实现，容器事件和事件监听器】
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:42
 **/
public class ApiTest {

    /**
     * 测试 切入点表达式
     */
    @Test
    public void testPointcutExpression() throws NoSuchMethodException {
        final String pointcutExpression = "execution(* cn.duktig.springframework.test.bean.UserService.*(..))";
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut(pointcutExpression);
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");
        // 是否能匹配到 切入点表达式指定的类和方法
        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    /**
     * 测试动态代理
     */
    @Test
    public void testDynamic() {
        // 目标对象
        IUserService userService = new UserService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.duktig.springframework.test" +
                ".bean.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxyJdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxyJdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxyCglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxyCglib.register("花花"));
    }

}

