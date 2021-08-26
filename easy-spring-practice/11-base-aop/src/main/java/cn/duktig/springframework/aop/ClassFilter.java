package cn.duktig.springframework.aop;

/**
 * description:定义类匹配类，用于切点找到给定的接口和目标类
 *
 * @author RenShiWei
 * Date: 2021/8/26 21:54
 **/
public interface ClassFilter {

    /**
     * 切入点指定的类/接口
     *
     * @param clazz the candidate target class
     * @return 是否匹配到
     */
    boolean matches(Class<?> clazz);

}
