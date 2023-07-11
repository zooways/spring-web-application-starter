package com.zoowayss.app.common.common.domain.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author zhongzb create on 2021/05/31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdReqVO {
    @NotNull
    private long id;
}
