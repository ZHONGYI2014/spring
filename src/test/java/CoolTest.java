
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


public class CoolTest {

    private final static Logger log = LoggerFactory.getLogger(CoolTest.class);


    @Test
    public void testResource() throws IOException {
        ClassPathResource res = new ClassPathResource("applicationContext.xml");
        log.info("classLoader :[{}]",res.getClassLoader().toString());
        log.info("URL :[{}]",res.getURL().toString());
        log.info("path :[{}]",res.getPath());
    }

    @Test
    public void assertTest() {
        Long tmp = (long)(Math.random() * 10000);
        System.out.println(tmp);
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
