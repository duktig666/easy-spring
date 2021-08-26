package cn.duktig.springframework.io;

import cn.duktig.springframework.util.ClassUtils;
import cn.hutool.core.lang.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * description: 获取ClassPath 的资源
 * <p>
 * 得到输入流
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:17
 **/
public class ClassPathResource implements Resource {

    /** 路径 */
    private final String path;

    /** 类加载器 */
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }


    /**
     * 获取输入流
     *
     * @return InputStream
     * @throws IOException IO异常
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }

}

