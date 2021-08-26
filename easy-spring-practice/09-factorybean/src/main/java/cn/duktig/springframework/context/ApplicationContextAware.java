package cn.duktig.springframework.context;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.Aware;

/**
 * description:应用上下文 感知接口
 * <p>
 * 实现此接口，既能感知到所属的 ApplicationContext
 *
 * @author RenShiWei
 * Date: 2021/8/26 14:41
 **/
public interface ApplicationContextAware extends Aware {

    /**
     * 设置应用上下文 方便感知
     *
     * @param applicationContext /
     * @throws BeansException/
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}

