package cn.duktig.springframework.context;

import java.util.EventListener;

/**
 * description: 应用事件监听器
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:11
 **/
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理一个应用事件
     *
     * @param event 需响应的事件
     */
    void onApplicationEvent(E event);

}
