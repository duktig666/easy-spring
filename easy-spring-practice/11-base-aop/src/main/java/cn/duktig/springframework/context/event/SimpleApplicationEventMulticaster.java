package cn.duktig.springframework.context.event;


import cn.duktig.springframework.beans.factory.BeanFactory;
import cn.duktig.springframework.context.ApplicationEvent;
import cn.duktig.springframework.context.ApplicationListener;

/**
 * description:事件广播器 的简单实现
 *
 * @author RenShiWei
 * Date: 2021/8/26 20:08
 **/
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener<ApplicationEvent> listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}
