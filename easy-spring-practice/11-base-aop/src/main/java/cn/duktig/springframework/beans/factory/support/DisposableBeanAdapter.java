package cn.duktig.springframework.beans.factory.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.DisposableBean;
import cn.duktig.springframework.beans.factory.config.BeanDefinition;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Method;

/**
 * description:销毁方法适配器(接口和配置)
 * <p>
 * 怎么有一个适配器的类呢，因为销毁方法有两种甚至多种方式，目前有实现接口 DisposableBean、配置信息 destroy-method，两种方式。而这两种方式的销毁动作是由
 * AbstractApplicationContext 在注册虚拟机钩子后看，虚拟机关闭前执行的操作动作。
 * 那么在销毁执行时不太希望还得关注都销毁那些类型的方法，它的使用上更希望是有一个统一的接口进行销毁，所以这里就新增了适配类，做统一处理。
 *
 * @author RenShiWei
 * Date: 2021/8/26 10:44
 **/
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    /**
     * 统一处理的销毁方法
     *
     * @throws Exception /
     */
    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && ! (bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean " +
                        "with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }

    }

}

