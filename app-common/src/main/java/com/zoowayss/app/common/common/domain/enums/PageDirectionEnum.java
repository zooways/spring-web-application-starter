package com.zoowayss.app.common.common.domain.enums;

import com.zoowayss.app.common.common.domain.vo.request.PageBaseReq;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description:
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/20 13:38
 */
@AllArgsConstructor
@Getter
public enum PageDirectionEnum {

    FORWARD, BACKWARD, FIRST;

    public static PageDirectionEnum of(PageBaseReq pageBaseReq) {
        if (pageBaseReq.getCursor()==null) {
            return FIRST;
        }
        if (pageBaseReq.getPageNo() < pageBaseReq.getPrePageNo()) {
            return FORWARD;
        }
        return BACKWARD;
    }
}
