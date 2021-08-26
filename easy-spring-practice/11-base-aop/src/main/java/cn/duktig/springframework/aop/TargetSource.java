package cn.duktig.springframework.aop;

/**
 * description:被代理的目标对象
 * <p>
 * 在目标对象类中提供 Object 入参属性，以及获取目标类 TargetClass 信息
 *
 * @author RenShiWei
 * Date: 2021/8/26 22:07
 **/
public class TargetSource {

    /** 被代理的目标对象 */
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * Return the type of targets returned by this {@link TargetSource}.
     * <p>Can return <code>null</code>, although certain usages of a
     * <code>TargetSource</code> might just work with a predetermined
     * target class.
     *
     * @return the type of targets returned by this {@link TargetSource}
     */
    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    /**
     * Return a target instance. Invoked immediately before the
     * AOP framework calls the "target" of an AOP method invocation.
     *
     * @return the target object, which contains the joinpoint
     */
    public Object getTarget() {
        return this.target;
    }

}
