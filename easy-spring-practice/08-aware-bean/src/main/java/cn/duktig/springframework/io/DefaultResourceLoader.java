package cn.duktig.springframework.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * description: 默认的资源加载器
 * <p>
 * 在获取资源的实现中，主要是把三种不同类型的资源处理方式进行了包装，分为：判断是否为ClassPath、URL以及文件
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:30
 **/
public class DefaultResourceLoader implements ResourceLoader {

    /**
     * 获取资源
     *
     * @param location 资源位置
     * @return 资源
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Target resource location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // 有文件前缀标识的，走ClassPathResource
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                //没有的走 远程文件
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 出异常了走本地文件，若本地也找不到，会报异常
                return new FileSystemResource(location);
            }
        }
    }

}

