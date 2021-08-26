package cn.duktig.springframework.aop.framework;

/**
 * description: 代理接口
 *
 * @author RenShiWei
 * Date: 2021/8/26 22:12
 **/
public interface AopProxy {

    /**
     * 获取代理类
     *
     * @return 代理类对象
     */
    Object getProxy();

}

