package com.controller;

import com.service.BeanAutowiredInjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private BeanAutowiredInjection service;


    //-----------------------------------------------------//
    //  注解 ResponseBody 是用于返回给页面用的                  //
    //-----------------------------------------------------//
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        logger.info(service.autowiredByName());
        logger.info("");
        logger.info("lucy");
        logger.info("haliluya");
        return "fresh blood";
    }
}
