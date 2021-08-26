package cn.duktig.springframework.context.event;

import cn.duktig.springframework.context.ApplicationContext;
import cn.duktig.springframework.context.ApplicationEvent;

/**
 * description: 用户实现的 事件基类
 * <p>
 * 定义事件的抽象类，所有的事件包括关闭、刷新，以及用户自己实现的事件，都需要继承这个类
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:05
 **/
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * 构造一个原型事件
     *
     * @param source 事件发生的对象
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 从事件源 得到 <code>ApplicationContext</code>
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}

