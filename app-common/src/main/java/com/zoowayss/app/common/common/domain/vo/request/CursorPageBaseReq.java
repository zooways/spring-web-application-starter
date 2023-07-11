package com.zoowayss.app.common.common.domain.vo.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 游标翻页请求
 * @author <a href="https://github.com/zooways">zooways</a>
 * @since 2023-03-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursorPageBaseReq {

    /**
     * 页面大小
     */
    @Min(0)
    @Max(100)
    private Integer pageSize = 10;

    /**
     * 游标（初始为null，后续请求附带上次翻页的游标）
     */
    private String cursor;

    public Page plusPage() {
        return new Page(1, this.pageSize);
    }

    @JsonIgnore
    public Boolean isFirstPage() {
        return StringUtils.isEmpty(cursor);
    }
}
