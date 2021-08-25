package cn.duktig.springframework.context;

import cn.duktig.springframework.beans.BeansException;

/**
 * description: 可配置的应用上下文 接口
 *
 * @author RenShiWei
 * Date: 2021/8/25 21:50
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException /
     */
    void refresh() throws BeansException;
}
