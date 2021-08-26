package cn.duktig.springframework.test.event;


import cn.duktig.springframework.context.ApplicationListener;
import cn.duktig.springframework.context.event.ContextClosedEvent;

/**
 * 自定义上下文关闭的事件
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:42
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
