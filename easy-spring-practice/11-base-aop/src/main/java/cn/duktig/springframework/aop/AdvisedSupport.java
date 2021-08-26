package cn.duktig.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * description:包装切面通知信息
 * <p>
 * 把代理、拦截、匹配的各项属性包装到一个类中，方便在 Proxy 实现类进行使用（这和业务开发中包装入参是一个道理）
 *
 * @author RenShiWei
 * Date: 2021/8/26 22:07
 **/
public class AdvisedSupport {

    /** 被代理的目标对象 */
    private TargetSource targetSource;
    /** 方法拦截器 */
    private MethodInterceptor methodInterceptor;
    /** 方法匹配器(检查目标方法是否符合通知条件) */
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

}

