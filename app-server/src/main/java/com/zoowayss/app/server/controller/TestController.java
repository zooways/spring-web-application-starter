package com.zoowayss.app.server.controller;

import com.zoowayss.app.common.common.annotation.RedisCache;
import com.zoowayss.app.common.common.annotation.RmRedisCache;
import com.zoowayss.app.common.common.domain.vo.request.PageBaseReq;
import com.zoowayss.app.common.common.domain.vo.response.ApiResult;
import com.zoowayss.app.common.common.utils.JsonUtils;
import com.zoowayss.app.server.common.service.ExpensesService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 测试
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/21 09:34
 */
@RequestMapping("/t")
@RestController
@Slf4j
public class TestController {


    @Resource
    private ExpensesService expensesService;

    @GetMapping
    @RedisCache(key = "#pageReq.pageNo", expireTime = 3, unit = TimeUnit.MINUTES)
    public ApiResult page(PageBaseReq pageReq) {
        return ApiResult.success(expensesService.queryPage(pageReq));
    }

    @GetMapping("/okhttp")
    public ApiResult okHttp() throws IOException {

        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(7890)))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/t")
                .addHeader("Content-Type", "application/json")
                .get()
                .build();
        String result = client.newCall(request).execute().body().string();
        return JsonUtils.toObj(result, ApiResult.class);
    }

    /**
     * 测试删除 redis 缓存
     * @param pageNo
     * @return
     */
    @RmRedisCache(prefixKey = "class com.zoowayss.app.server.controller.TestController#page",key = "#pageNo")
    @GetMapping("/rm")
    public ApiResult test(int pageNo){
        return ApiResult.success();
    }
}