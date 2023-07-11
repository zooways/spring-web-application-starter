package com.zoowayss.app.common.common.domain.vo.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 基础翻页请求
 * @author <a href="https://github.com/zooways">zooways</a>
 * @since 2023-03-19
 */
@Data
public class PageBaseReq {

    @Min(0)
    @Max(50)
    /**
     * 页面大小
     */
    private Integer pageSize = 10;

    /**
     * 页面索引（从1开始）
     */
    private Integer pageNo = 1;

    /**
     * 获取mybatisPlus的page
     *
     * @return
     */
    public Page plusPage() {
        return new Page(pageNo, pageSize);
    }
}
