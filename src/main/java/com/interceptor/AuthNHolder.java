package com.interceptor;

import java.util.Map;

public class AuthNHolder {

    /** ThreadLocal 隔离用户信息, 其它线程不可见, 保证线程安全, 以及防止其它用户修改当前线程中的内容 */
    private static final ThreadLocal<Map<String,String>> threadLocal = new ThreadLocal<>();

    public static void setThreadLocal(Map<String,String> map) {
        threadLocal.set(map);
    }

    public static String getThreadLocal(String key) {
        Map<String,String> currentMap = threadLocal.get();
        return currentMap.get(key);
    }

    public static String userName() {return getThreadLocal("userName");}
}
