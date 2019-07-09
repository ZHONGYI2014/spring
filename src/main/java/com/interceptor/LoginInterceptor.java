package com.interceptor;

import bean.Info;
import com.dao.TestDao;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.URLParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    /** 接口开放时间 */
    private static final Integer open = 8;

    /** 接口开放时间 */
    private static final Integer close = 19;

    @Autowired
    private TestDao testDao;

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String, String> userMap = new HashMap<>();

        /** 获取参数 */
        String _id = null;
        String url = request.getRequestURL().toString() + "?" + request.getQueryString();
        _id = URLParser.fromURL(url).compile().getParameter("_id");
        Info info = testDao.findById(Integer.valueOf(_id));
        Map<String,String> infoMap = new HashMap<>();
        infoMap.put("userName", info.getName());
        infoMap.put("dept", info.getDept());
        AuthNHolder.setThreadLocal(infoMap);
        int hour = LocalDateTime.now().getHour();
        log.info("currentTime is {}", LocalDateTime.now());
        if (hour < close && hour > open) {
            //只有在 9点-17点 接口才对外开放, 返回false 直接
         return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("finish");
        super.afterCompletion(request, response, handler, ex);
    }
}
