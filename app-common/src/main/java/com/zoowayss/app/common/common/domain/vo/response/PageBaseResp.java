package com.zoowayss.app.common.common.domain.vo.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础翻页返回
 * @author <a href="https://github.com/zooways">zooways</a>
 * @since 2023-03-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBaseResp<T> {

    /**
     * 当前页数
     */
    private Integer pageNo;

    /**
     * 每页查询数量
     */
    private Integer pageSize;


    /**
     * 总记录数
     */
    private Long totalRecords;

    /**
     * 是否最后一页
     */
    private Boolean isLast = Boolean.FALSE;

    /**
     * 数据列表
     */
    private List<T> list;


    public static PageBaseResp empty() {
        PageBaseResp r = new PageBaseResp();
        r.setPageNo(1);
        r.setPageSize(0);
        r.setIsLast(true);
        r.setTotalRecords(0L);
        r.setList(new ArrayList());
        return r;
    }

    public static <T> PageBaseResp<T> init(Integer pageNo, Integer pageSize, Long totalRecords, Boolean isLast, List<T> list) {
        return new PageBaseResp<>(pageNo, pageSize, totalRecords, isLast, list);
    }

    public static <T> PageBaseResp<T> init(Integer pageNo, Integer pageSize, Long totalRecords, List<T> list) {
        return new PageBaseResp<>(pageNo, pageSize, totalRecords, isLastPage(totalRecords, pageNo, pageSize), list);
    }

    public static <T> PageBaseResp<T> init(IPage<T> page) {
        return init((int) page.getCurrent(), (int) page.getSize(), page.getTotal(), page.getRecords());
    }

    public static <T> PageBaseResp<T> init(IPage page, List<T> list) {
        return init((int) page.getCurrent(), (int) page.getSize(), page.getTotal(), list);
    }

    public static <T> PageBaseResp<T> init(PageBaseResp resp, List<T> list) {
        return init(resp.getPageNo(), resp.getPageSize(), resp.getTotalRecords(), resp.getIsLast(), list);
    }

    /**
     * 是否是最后一页
     */
    public static Boolean isLastPage(long totalRecords, int pageNo, int pageSize) {
        if (pageSize == 0) {
            return false;
        }
        long pageTotal = totalRecords / pageSize + (totalRecords % pageSize == 0 ? 0 : 1);
        return pageNo >= pageTotal ? true : false;
    }
}
