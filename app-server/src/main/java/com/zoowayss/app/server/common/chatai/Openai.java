package com.zoowayss.app.server.common.chatai;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/21 10:55
 */

@Slf4j
@Component
public class Openai {

    @SneakyThrows
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  String chat(String msg) {
      log.info("chatting with openai...{}", msg);
        Thread.sleep(3 * 1000);
        return msg + StrUtil.C_COLON + RandomUtil.randomNumbers(5);
    }
}
