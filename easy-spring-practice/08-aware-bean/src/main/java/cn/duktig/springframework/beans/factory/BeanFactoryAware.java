package cn.duktig.springframework.beans.factory;

import cn.duktig.springframework.beans.BeansException;

/**
 * description: 工厂感知 接口
 * <p>
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 * @author RenShiWei
 * Date: 2021/8/26 14:36
 **/
public interface BeanFactoryAware extends Aware {

    /**
     * 感知所属的工厂
     *
     * @param beanFactory /
     * @throws BeansException /
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}

