package com.nekogee.muses.service;

import com.nekogee.muses.entity.SysUser;

public interface SysUserService {
        /**通过username查找用户信息;*/
        SysUser findUserByUsername(String username);

        SysUser findUserByPhone(String phone);

        SysUser findUserByEmail(String email);
}