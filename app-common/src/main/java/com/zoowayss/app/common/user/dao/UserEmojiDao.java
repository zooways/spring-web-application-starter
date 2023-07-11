package com.zoowayss.app.common.user.dao;

import com.zoowayss.app.common.user.domain.entity.UserEmoji;
import com.zoowayss.app.common.user.mapper.UserEmojiMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表情包 服务实现类
 * </p>
 *
 * @author <a href="https://github.com/zooways">zooways</a>
 * @since 2023-07-09
 */
@Service
public class UserEmojiDao extends ServiceImpl<UserEmojiMapper, UserEmoji> {

    public List<UserEmoji> listByUid(Long uid) {
        return lambdaQuery().eq(UserEmoji::getUid, uid).list();
    }

    public long countByUid(Long uid) {
        return lambdaQuery().eq(UserEmoji::getUid, uid).count();
    }
}
