package cn.duktig.springframework.context;

import cn.duktig.springframework.beans.factory.HierarchicalBeanFactory;
import cn.duktig.springframework.beans.factory.ListableBeanFactory;
import cn.duktig.springframework.core.io.ResourceLoader;

/**
 * description:上下文接口
 * <p>
 * 继承于 ListableBeanFactory，也就继承了关于 BeanFactory 方法，比如一些 getBean 的方法
 *
 * @author RenShiWei
 * Date: 2021/8/25 21:49
 **/
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader,
        ApplicationEventPublisher {


}

