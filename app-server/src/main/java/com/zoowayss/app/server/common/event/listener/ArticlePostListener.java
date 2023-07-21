package com.zoowayss.app.server.common.event.listener;

import com.zoowayss.app.common.common.event.ArticlePostEvent;
import com.zoowayss.app.server.common.chatai.Openai;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.annotation.Resource;

import static com.zoowayss.app.common.common.config.ThreadPoolConfig.AICHAT_EXECUTOR;

/**
 * @Description:
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/21 11:06
 */
@Getter
@Component
@Slf4j
public class ArticlePostListener {

    @Resource
    private Openai openai;

    /**
     * fallbackExecution = false: 如果当前不存在事物，直接丢弃，不做任何处理
     * fallbackExecution = true: 如果当前不存在事物，直接执行
     * @param articlePostEvent
     */
    @Async(AICHAT_EXECUTOR)
    @TransactionalEventListener(classes = ArticlePostEvent.class, fallbackExecution = true)
    public void fillArticle(ArticlePostEvent articlePostEvent) {
        String content = openai.chat(articlePostEvent.getUserMsg().getMsg());
        log.info("fill article success,saving into db...{}", content);
    }
}
