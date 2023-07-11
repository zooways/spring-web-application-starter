package com.zoowayss.app.common.common.utils.oss.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Description: 上传url请求入参
 * Author: <a href="https://github.com/zooways">zooways</a>
 * Date: 2023-03-23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OssReq {
    /**
     * 文件存储路径
     */
    private String filePath;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 请求的uid
     */
    private Long uid;
    /**
     * 自动生成地址
     */
    @Builder.Default
    private boolean autoPath = true;
}
