import bean.FooBar;
import bean.NewsProvider;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class springTest {

    @Test
    public void testBeanFactory() {
        //------------------------------------------------------------------------
        //  step1. 定位资源
        //------------------------------------------------------------------------
        ClassPathResource res = new ClassPathResource("spring-test.xml");
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

        FooBar obj = factory.getBean(FooBar.class);
        obj.foo("spring-test.xml");

    }
}
