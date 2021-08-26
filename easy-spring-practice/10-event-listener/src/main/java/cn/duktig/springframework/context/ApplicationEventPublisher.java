package cn.duktig.springframework.context;

/**
 * description: 事件发布者
 * <p>
 * 整个一个事件的发布接口，所有的事件都需要从这个接口发布出去
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:41
 **/
public interface ApplicationEventPublisher {

    /**
     * 通知事件给 所有注册到此应用程序的监听器
     *
     * @param event 需发布的事件
     */
    void publishEvent(ApplicationEvent event);

}

