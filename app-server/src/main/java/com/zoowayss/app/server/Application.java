package com.zoowayss.app.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/7/11 11:22
 * @Version: 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.zoowayss.app.**"})
@MapperScan(basePackages = {"com.zoowayss.app.**"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
