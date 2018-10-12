package service.impl;

import org.springframework.stereotype.Service;
import service.BeanAutowiredInjection;

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
