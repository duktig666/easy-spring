package cn.duktig.springframework.context.event;

/**
 * description:上下文刷新事件
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:08
 **/
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }

}

