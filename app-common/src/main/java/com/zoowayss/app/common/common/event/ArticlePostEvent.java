package com.zoowayss.app.common.common.event;

import com.zoowayss.app.common.user.domain.entity.UserMsg;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Description:
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/21 10:58
 */
@Getter
public class ArticlePostEvent extends ApplicationEvent {

    private UserMsg userMsg;

    public ArticlePostEvent(Object source, UserMsg userMsg) {
        super(source);
        this.userMsg = userMsg;
    }
}
