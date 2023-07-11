package com.zoowayss.app.common.common.utils;

import com.zoowayss.app.common.common.domain.dto.RequestInfo;

/**
 * Description: 请求上下文
 * Author: <a href="https://github.com/zooways">zooways</a>
 * Date: 2023-04-05
 */
public class RequestHolder {

    private static final ThreadLocal<RequestInfo> threadLocal = new ThreadLocal<>();

    public static void set(RequestInfo requestInfo) {
        threadLocal.set(requestInfo);
    }

    public static RequestInfo get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
