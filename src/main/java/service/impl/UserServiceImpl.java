package service.impl;

import domain.User;
import ioc.DefaultA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;


public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {

    }


    public User getUserByName(String name) {
        User user = new User();
        user.setUserName(name);
        user.setUserPhone("15070951346");
        user.setUserEmail("478741233@qq.com");
        logger.info("userName: {}", user.getUserName());
        return user;
    }
}
