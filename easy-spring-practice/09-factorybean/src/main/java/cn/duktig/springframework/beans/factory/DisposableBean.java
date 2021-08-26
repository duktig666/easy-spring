package cn.duktig.springframework.beans.factory;

/**
 * description:将要销毁的bean
 *
 * @author RenShiWei
 * Date: 2021/8/26 10:21
 **/
public interface DisposableBean {

    /**
     * bean对象需要销毁时调用
     *
     * @throws Exception /
     */
    void destroy() throws Exception;

}

