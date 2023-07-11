package com.zoowayss.app.common.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description: 修改用户名
 * Author: <a href="https://github.com/zooways">zooways</a>
 * Date: 2023-03-23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SummeryInfoDTO {
    /**
     * 用户id
     */
    private Long uid;
    /**
     * 是否需要刷新
     */
    private Boolean needRefresh = Boolean.TRUE;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 归属地
     */
    private String locPlace;
    /**
     * 佩戴的徽章id
     */
    private Long wearingItemId;
    /**
     * 用户拥有的徽章id列表
     */
    List<Long> itemIds;

    public static SummeryInfoDTO skip(Long uid) {
        SummeryInfoDTO dto = new SummeryInfoDTO();
        dto.setUid(uid);
        dto.setNeedRefresh(Boolean.FALSE);
        return dto;
    }
}

