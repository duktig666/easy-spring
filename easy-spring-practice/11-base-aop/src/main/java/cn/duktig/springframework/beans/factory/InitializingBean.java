package cn.duktig.springframework.beans.factory;

/**
 * description: 正在初始化的bean接口
 *
 * @author RenShiWei
 * Date: 2021/8/26 10:19
 **/
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception /
     */
    void afterPropertiesSet() throws Exception;

}
