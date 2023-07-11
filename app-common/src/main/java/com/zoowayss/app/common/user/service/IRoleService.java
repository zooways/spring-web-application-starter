package com.zoowayss.app.common.user.service;

import com.zoowayss.app.common.user.domain.enums.RoleEnum;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author <a href="https://github.com/zooways">zooways</a>
 * @since 2023-06-04
 */
public interface IRoleService {

    /**
     * 是否有某个权限，临时做法
     *
     * @return
     */
    boolean hasPower(Long uid, RoleEnum roleEnum);

}
