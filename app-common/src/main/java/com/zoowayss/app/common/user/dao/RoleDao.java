package com.zoowayss.app.common.user.dao;

import com.zoowayss.app.common.user.domain.entity.Role;
import com.zoowayss.app.common.user.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author <a href="https://github.com/zooways">zooways</a>
 * @since 2023-06-04
 */
@Service
public class RoleDao extends ServiceImpl<RoleMapper, Role> {

}
