package cn.duktig.springframework.beans;

/**
 * description:spring容器的bean异常
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:26
 **/
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

