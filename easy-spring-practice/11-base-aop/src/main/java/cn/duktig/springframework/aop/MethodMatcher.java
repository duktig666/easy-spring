package cn.duktig.springframework.aop;

import java.lang.reflect.Method;

/**
 * description:方法匹配，找到表达式范围内匹配下的目标类和方法
 *
 * @author RenShiWei
 * Date: 2021/8/26 21:55
 **/
public interface MethodMatcher {

    /**
     * 切入点指定的类/接口
     *
     * @param method      /
     * @param targetClass /
     * @return 是否匹配到aspectj
     */
    boolean matches(Method method, Class<?> targetClass);

}
