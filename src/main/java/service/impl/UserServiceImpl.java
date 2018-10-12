package service.impl;

import domain.User;
import ioc.DefaultA;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

public class UserServiceImpl implements UserService {


    public UserServiceImpl() {

    }


    public User getUserByName(String name) {
        User user = new User();
        user.setUserName(name);
        user.setUserPhone("15070951346");
        user.setUserEmail("478741233@qq.com");
        return user;
    }
}
