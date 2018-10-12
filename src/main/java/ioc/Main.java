package ioc;

import domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        initializeIOC();
      // fileSystemXmlApplicationContext();

    }

    /**
     * 初始化IOC容器
     */
    public static void initializeIOC() {

        //------------------------------------------------------------------------
        //  step1. 定位资源
        //------------------------------------------------------------------------
        ClassPathResource res = new ClassPathResource("spring.xml");
        //------------------------------------------------------------------------
        //  step2. 创建容器
        //      1) DefaultListableBeanFactory 实现了 BeanDefinitionRegistry 接口
        //------------------------------------------------------------------------
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //------------------------------------------------------------------------
        //  step3. 注入
        //      1) 创建一个加载BeanDefinition 的读取器，通过一个回调配置给BeanFactory
        //------------------------------------------------------------------------
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        //------------------------------------------------------------------------

        UserService service = factory.getBean(UserServiceImpl.class);
        User user = service.getUserByName("cool");
        System.out.println(user.getUserPhone());
        System.out.println(factory.isSingleton("userService"));
    }

    public static void fileSystemXmlApplicationContext() {
        //路径需要使用双斜杠
        String path = "//Users//pengy//myProjects//spring//src//main//resources//spring.xml";
        String path2 = "//Users//pengy//myProjects//spring//src//main//resources//spring-test.xml";
        //可以传多个配置文件，配置多个容器
        ApplicationContext context = new FileSystemXmlApplicationContext(path);
        UserService service = context.getBean(UserServiceImpl.class);
        User user = service.getUserByName("cool");
        System.out.println(user.getUserPhone());
    }
}
