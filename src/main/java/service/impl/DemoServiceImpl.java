package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import service.DemoService;
import service.UserService;

public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserService userService;

    @Override
    public void getServiceName() {
        System.out.println("this is demoService!!!");
    }
}
