package com.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    /** 接口开放时间 */
    private static final Integer open = 9;

    /** 接口开放时间 */
    private static final Integer close = 17;

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int hour = LocalDateTime.now().getHour();
        log.info("currentTime is {}", LocalDateTime.now());
        if (hour > close && hour < open) {
            //只有在 9点-17点 接口才对外开放, 返回false 直接
         return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("finish");
        super.afterCompletion(request, response, handler, ex);
    }
}
