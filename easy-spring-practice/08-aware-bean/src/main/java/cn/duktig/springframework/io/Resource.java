package cn.duktig.springframework.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * description:资源接口 获取输入流
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:14
 **/
public interface Resource {

    /**
     * 获取输入流
     *
     * @return InputStream
     * @throws IOException IO异常
     */
    InputStream getInputStream() throws IOException;

}
