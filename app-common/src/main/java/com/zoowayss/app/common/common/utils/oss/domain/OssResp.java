package com.zoowayss.app.common.common.utils.oss.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Description: 上传url请求出参
 * Author: <a href="https://github.com/zooways">zooways</a>
 * Date: 2023-03-23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OssResp {

    /**
     * 上传的临时url
     */
    private String uploadUrl;

    /**
     * 成功后能够下载的url
     */
    private String downloadUrl;
}
