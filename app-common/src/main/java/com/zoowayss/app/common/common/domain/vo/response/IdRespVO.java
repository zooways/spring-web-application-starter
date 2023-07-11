package com.zoowayss.app.common.common.domain.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhongzb create on 2021/05/31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdRespVO {
    /**
     * id
     */
    private long id;

    public static IdRespVO id(Long id) {
        IdRespVO idRespVO = new IdRespVO();
        idRespVO.setId(id);
        return idRespVO;
    }
}
