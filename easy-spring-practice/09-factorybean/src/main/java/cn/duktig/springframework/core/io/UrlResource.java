package cn.duktig.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * description: 获取远程 的资源
 * <p>
 * 得到输入流
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:17
 **/
public class UrlResource implements Resource {

    /** 远程资源的url */
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
    }

    /**
     * 获取输入流
     *
     * @return InputStream
     * @throws IOException IO异常
     */
    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException ex) {
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection) con).disconnect();
            }
            throw ex;
        }
    }

}
