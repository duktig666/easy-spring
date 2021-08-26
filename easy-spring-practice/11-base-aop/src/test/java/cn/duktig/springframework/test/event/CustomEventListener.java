package cn.duktig.springframework.test.event;


import cn.duktig.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * 监听 CustomEvent 事件的监听器
 * <p>
 * 处理自定义操作
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:42
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }

}
