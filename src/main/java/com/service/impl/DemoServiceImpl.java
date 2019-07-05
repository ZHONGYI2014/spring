package com.service.impl;

import com.service.DemoService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserService userService;

    @Override
    public void getServiceName() {
        System.out.println("this is demoService!!!");
    }
}
