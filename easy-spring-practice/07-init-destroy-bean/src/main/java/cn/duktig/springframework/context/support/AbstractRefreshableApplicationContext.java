package cn.duktig.springframework.context.support;

import cn.duktig.springframework.beans.BeansException;
import cn.duktig.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.duktig.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * description: 抽象可刷新的应用上下文
 * <p>
 * 获取Bean工厂和加载资源
 *
 * @author RenShiWei
 * Date: 2021/8/26 9:10
 **/
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    /**
     * 刷新bean 工厂，重新加载新建的bean工厂
     *
     * @throws BeansException /
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 创建 bean工厂
     *
     * @return 新建的bean工厂
     */
    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载 bean工厂中所有的 bean定义
     *
     * @param beanFactory /
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    /**
     * 获取 bean工厂
     *
     * @return bean工厂
     */
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}

