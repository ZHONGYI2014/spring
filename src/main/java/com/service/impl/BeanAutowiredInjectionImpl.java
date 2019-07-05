package com.service.impl;

import com.service.BeanAutowiredInjection;
import org.springframework.stereotype.Service;

@Service
public class BeanAutowiredInjectionImpl implements BeanAutowiredInjection {

    @Override
    public String autowiredByName() {

        return "autowiredByName";
    }

    @Override
    public String autowiredByType() {
        return "autowiredByType";
    }
}
