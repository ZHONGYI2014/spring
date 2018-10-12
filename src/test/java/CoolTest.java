
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

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
    public void sayHi() {
        String str = null;
        log.info("Hi spring~");
    }



}
