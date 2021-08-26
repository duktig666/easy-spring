package cn.duktig.springframework.context.event;

import cn.duktig.springframework.context.ApplicationEvent;
import cn.duktig.springframework.context.ApplicationListener;

/**
 * description:事件广播器
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:09
 **/
public interface ApplicationEventMulticaster {

    /**
     * 增加监听器
     *
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 移除监听器
     *
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 广播应用事件给 监听器
     *
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);

}

