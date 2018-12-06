
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.io.IOException;


public class CoolTest {

    private final static Logger log = LoggerFactory.getLogger(CoolTest.class);


    @Test
    public void testResource() throws IOException {
        ClassPathResource res = new ClassPathResource("spring.xml");
        log.info("classLoader :[{}]",res.getClassLoader().toString());
        log.info("URL :[{}]",res.getURL().toString());
        log.info("path :[{}]",res.getPath());
    }

    @Test
    public void assertTest() {
        String[] m = new String[3];
        m[0] = "1";
        m[1] = "2";
        m[2] = "3";
        sayHi(m);
    }

    public void sayHi(String ... ss) {
        int j =0;
        String[] array = new String[ss.length];
        for (String i : ss) {
            array[j++] = i;
        }
        System.out.println(array.toString());
    }




}
