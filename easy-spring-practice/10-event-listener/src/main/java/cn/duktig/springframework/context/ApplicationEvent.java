package cn.duktig.springframework.context;

import java.util.EventObject;

/**
 * description:定义出具备事件功能的抽象类 ApplicationEvent，后续所有事件的类都需要继承这个类
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:00
 **/
public abstract class ApplicationEvent extends EventObject {

    /**
     * 构造一个原型事件
     *
     * @param source 事件发生的对象
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

}

