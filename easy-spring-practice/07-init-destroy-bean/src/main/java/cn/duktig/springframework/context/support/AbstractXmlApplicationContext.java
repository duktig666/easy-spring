package cn.duktig.springframework.context.support;

import cn.duktig.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.duktig.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * description:抽象的配置信息加载的过程
 * <p>
 * 上下文中对配置信息的加载
 *
 * @author RenShiWei
 * Date: 2021/8/26 9:16
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    /**
     * 加载 bean工厂中所有的 bean定义
     * <p>
     * 使用 XmlBeanDefinitionReader 类，处理了关于 XML 文件配置信息的操作
     *
     * @param beanFactory /
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取配置资源的所有位置
     * <p>
     * 从入口上下文类，拿到配置信息的地址描述
     *
     * @return 配置资源的所有位置信息
     */
    protected abstract String[] getConfigLocations();

}

