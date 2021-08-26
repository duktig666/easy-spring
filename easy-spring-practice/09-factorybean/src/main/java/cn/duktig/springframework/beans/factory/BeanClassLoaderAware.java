package cn.duktig.springframework.beans.factory;

/**
 * description:类加载器感知接口
 * <p>
 * 实现此接口，既能感知到所属的 ClassLoader
 *
 * @author RenShiWei
 * Date: 2021/8/26 14:39
 **/
public interface BeanClassLoaderAware extends Aware {

    /**
     * 设置类加载器 方便感知
     *
     * @param classLoader /
     */
    void setBeanClassLoader(ClassLoader classLoader);

}

