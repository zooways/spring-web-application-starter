package com.zoowayss.app.common.sensitive.dao;

import com.zoowayss.app.common.sensitive.domain.SensitiveWord;
import com.zoowayss.app.common.sensitive.mapper.SensitiveWordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 敏感词DAO
 *
 * @author zhaoyuhang
 * @since 2023/06/11
 */
@Service
public class SensitiveWordDao extends ServiceImpl<SensitiveWordMapper, SensitiveWord> {

}
