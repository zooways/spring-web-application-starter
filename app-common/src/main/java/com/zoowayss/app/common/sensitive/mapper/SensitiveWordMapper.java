package com.zoowayss.app.common.sensitive.mapper;

import com.zoowayss.app.common.sensitive.domain.SensitiveWord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 敏感词Mapper
 *
 * @author zhaoyuhang
 * @since 2023-05-21
 */
@Mapper
public interface SensitiveWordMapper extends BaseMapper<SensitiveWord> {

}