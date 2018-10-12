package exception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class BaseExceptionTest {

    private static final Logger log = LoggerFactory.getLogger(BaseExceptionTest.class);

    @Test
    public void tesStringFormat() {
        String s = MessageFormat.format("aaa{0}bbb","中国");
        log.info(s.toString());
    }

}