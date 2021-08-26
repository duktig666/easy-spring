package cn.duktig.springframework.beans.factory;

/**
 * description: 工厂对象 接口
 * <p>
 * 最大的一个作用是：可以让我们自定义Bean的创建过程
 *
 * @author RenShiWei
 * Date: 2021/8/26 16:30
 **/
public interface FactoryBean<T> {

    /**
     * 获取对象
     *
     * @return /
     * @throws Exception /
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     *
     * @return /
     */
    Class<?> getObjectType();

    /**
     * 判断是否为单例对象
     *
     * @return /
     */
    boolean isSingleton();

}

