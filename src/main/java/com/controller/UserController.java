package com.controller;

import com.interceptor.AuthNHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login")
    @ResponseBody
    public String login() {
        logger.info("threadId: " + Thread.currentThread().getId());
        logger.info(AuthNHolder.userName());
        return "GOOD";
    }
}
