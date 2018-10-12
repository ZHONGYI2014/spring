package exception;

import enums.ServerExceptionEnum;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class ServerExceptionTest {

    private static final Logger log = LoggerFactory.getLogger(ServerExceptionTest.class);

    @Test
    public void testException() {
        try {
            throw new ServerException(ServerExceptionEnum.SYSTEM_ERROR);
        } catch (ServerException se) {
            log.error(se.getMessage());
        }

    }

    @Test
    public void testAnoException() {
        try {
            throw new ServerException(ServerExceptionEnum.PARAMS_CANNOT_BE_NULL,"userName");
        } catch (ServerException se) {
            log.error(se.getMessage());
        }

    }

}