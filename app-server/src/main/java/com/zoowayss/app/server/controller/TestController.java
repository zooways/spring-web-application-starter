package com.zoowayss.app.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public void test() {
        log.info("accept request");
    }
}
