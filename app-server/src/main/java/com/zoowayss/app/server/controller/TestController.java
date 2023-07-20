package com.zoowayss.app.server.controller;

import com.zoowayss.app.common.common.annotation.RedisCache;
import com.zoowayss.app.common.common.domain.vo.request.PageBaseReq;
import com.zoowayss.app.common.common.domain.vo.response.ApiResult;
import com.zoowayss.app.server.common.service.ExpensesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/7/11 11:26
 * @Version: 1.0
 */
@RequestMapping("/t")
@RestController
@Slf4j
public class TestController {


    @Resource
    private ExpensesService expensesService;

    @GetMapping
    @RedisCache(key = "#pageReq.pageNo",expireTime = 3,unit = TimeUnit.SECONDS)
    public ApiResult page(PageBaseReq pageReq) {
        return ApiResult.success(expensesService.queryPage(pageReq));
    }
}


