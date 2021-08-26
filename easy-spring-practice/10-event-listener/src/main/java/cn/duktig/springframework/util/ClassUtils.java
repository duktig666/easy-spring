package cn.duktig.springframework.util;

/**
 * description: Class对象 工具类
 *
 * @author RenShiWei
 * Date: 2021/8/25 19:19
 **/
public class ClassUtils {

    /**
     * 获取 类加载器
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            // 获取当前线程上下文的 类加载器
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            // 没有获取到，使用当前工具类作为类加载（applicationClassLoader）
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

    /**
     * 检查这个类是否是 Cglib 生成的 （通过类的Class对象）
     *
     * @param clazz the class to check
     */
    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyClassName(clazz.getName()));
    }

    /**
     * 检查这个类是否是 Cglib 生成的 （通过类 全限名）
     *
     * @param className the class name to check
     */
    public static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }

}

