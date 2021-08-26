package cn.duktig.springframework.core.io;

/**
 * description: 资源加载器 接口
 * <p>
 * 按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的类服务下进行处理，外部用户只需要传递资源地址即可，简化使用。
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:28
 **/
public interface ResourceLoader {

    /**
     * 资源默认前缀: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源
     *
     * @param location 资源位置
     * @return 资源
     */
    Resource getResource(String location);

}

