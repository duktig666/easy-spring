package cn.duktig.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * description: 获取本地文件 的资源
 * <p>
 * 得到输入流
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:17
 **/
public class FileSystemResource implements Resource {

    /** 文件 */
    private final File file;

    /** 文件路径 */
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    /**
     * 获取输入流
     *
     * @return InputStream
     * @throws IOException IO异常
     */
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }

}
