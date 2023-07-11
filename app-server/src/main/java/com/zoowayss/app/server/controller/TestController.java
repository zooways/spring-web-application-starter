package com.zoowayss.app.server.controller;

import com.zoowayss.app.common.common.domain.vo.response.ApiResult;
import com.zoowayss.app.common.common.utils.oss.MinIOTemplate;
import com.zoowayss.app.common.common.utils.oss.domain.OssReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    private MinIOTemplate minIOTemplate;

    @PostMapping
    public ApiResult test() {
        OssReq ossReq = OssReq.builder()
                .fileName("test.jpg")
                .filePath("/image")
                .uid(321123L)
                .build();
        return ApiResult.success(minIOTemplate.getPreSignedObjectUrl(ossReq));
    }
}
