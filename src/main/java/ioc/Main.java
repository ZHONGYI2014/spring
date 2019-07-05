package ioc;

import domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import service.UserService;
import service.impl.UserServiceImpl;

import java.net.URL;

public class Main {

    public static void main(String[] args) {
      //  initializeIOC();
      fileSystemXmlApplicationContext();

    }

    /**
     * 初始化IOC容器
     */
    public static void initializeIOC() {

        //------------------------------------------------------------------------
        //  step1. 定位资源
        //------------------------------------------------------------------------
        ClassPathResource res = new ClassPathResource("applicationContext.xml");
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
        //可以传多个配置文件，配置多个容器
        URL url = Main.class.getClassLoader().getResource("applicationContext.xml");
        String filePath = url.getPath().replaceAll("/", "//");
        ApplicationContext context = new FileSystemXmlApplicationContext(filePath);

       // ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = context.getBean(UserServiceImpl.class);
        User user = service.getUserByName("cool");
        System.out.println("Main result : " + user.getUserPhone());

    }
}
