package cn.duktig.springframework.aop;

/**
 * description: 切入点接口
 *
 * @author RenShiWei
 * Date: 2021/8/26 21:53
 **/
public interface Pointcut {

    /**
     * 匹配表达式匹配到的接口和目标类
     *
     * @return the ClassFilter (never <code>null</code>)
     */
    ClassFilter getClassFilter();

    /**
     * 匹配表达式匹配到的目标类的方法
     *
     * @return the MethodMatcher (never <code>null</code>)
     */
    MethodMatcher getMethodMatcher();

}

