package cn.duktig.springframework.context.event;

/**
 * description: 上下文关闭事件
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:07
 **/
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }

}

