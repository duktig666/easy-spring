package cn.duktig.springframework.test.event;


import cn.duktig.springframework.context.ApplicationListener;
import cn.duktig.springframework.context.event.ContextRefreshedEvent;

/**
 * 自定义上下文刷新的事件
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:42
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}
