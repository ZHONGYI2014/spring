package com.controller;

import java.util.Map;

/**
 * 获取当前登录人的信息
 */
public class UserInfo {

    /**
     * 思考：为什么需要用ThreadLocal来维护这个map
     * 直接用一个map<userId, UserInfo> 这样来装客户的信息不也可以吗 ？
     * 可是可以，但如果是这样的话，那这个静态变量维护在方法区中，被所有的线程共享，所以说这样是不安全的
     */
    private static final ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

    /**
     * 封装登录用户信息
     * @param map
     */
    public static void wrapper(Map<String, String> map) {
        threadLocal.set(map);
    }

}
