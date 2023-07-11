package com.zoowayss.app.common.user.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * Description:
 * Author: <a href="https://github.com/zooways">zooways</a>
 * Date: 2023-04-18
 */
@Data
public class IpResult<T> implements Serializable {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误消息
     */
    private String msg;
    /**
     * 返回对象
     */
    private T data;

    public boolean isSuccess() {
        return Objects.nonNull(this.code) && this.code == 0;
    }
}
