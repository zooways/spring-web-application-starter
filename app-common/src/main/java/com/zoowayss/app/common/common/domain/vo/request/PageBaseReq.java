package com.zoowayss.app.common.common.domain.vo.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 基础翻页请求
 *
 * @author <a href="https://github.com/zooways">zooways</a>
 * @since 2023-03-19
 */
@Data
@ToString
public class PageBaseReq implements Serializable {

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

    private String cursor;

    /**
     * 上一页
     * |prePageNo - pageNo| != 1 : 需要计算偏移量
     * <p>prePageNo < pageNo : 向后翻页  此时 id > cursor and limit (pageNo-prePageNo-1) * pageSize,pageSize </p>
     * <p>prePageNo > pageNo : 向前翻页  此时 id < cursor and limit (prePageNo - pageNo) * pageSize,pageSize</p>
     */
    private Integer prePageNo;

    /**
     * 获取mybatisPlus的page
     *
     * @return
     */
    public Page plusPage() {
        return new Page(pageNo, pageSize);
    }

    public static <T> Page<T> of(PageBaseReq pageBaseReq) {
        Integer prePage = pageBaseReq.getPrePageNo();
        Integer pageNo = pageBaseReq.getPageNo();
        if (pageBaseReq.getCursor()==null ){
            return new Page<>(1, pageBaseReq.getPageSize());
        }
        if (prePage < pageNo) {
            return new Page<>((pageNo - prePage) , pageBaseReq.getPageSize());
        }

        return new Page<>( (prePage - pageNo+1) , pageBaseReq.getPageSize());
    }
}
