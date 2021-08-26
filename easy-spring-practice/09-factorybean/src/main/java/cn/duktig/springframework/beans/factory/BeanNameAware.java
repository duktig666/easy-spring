package cn.duktig.springframework.beans.factory;

/**
 * description:bean名称感知接口
 * <p>
 * 实现此接口，既能感知到所属的 BeanName
 *
 * @author RenShiWei
 * Date: 2021/8/26 14:40
 **/
public interface BeanNameAware extends Aware {

    /**
     * 设置bean名称方便感知
     *
     * @param beanName /
     */
    void setBeanName(String beanName);

}

