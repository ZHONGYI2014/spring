package dao;

import bean.Info;
import com.alibaba.fastjson.JSON;
import com.dao.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDaoTest {

    private final Logger log = LoggerFactory.getLogger(TestDaoTest.class);

    @Autowired
    private TestDao testDao;

    @Test
    public void findBeauty() {
        List<Info> result = testDao.findBeauty();
        log.info("result : {}", JSON.toJSONString(result));
    }
}