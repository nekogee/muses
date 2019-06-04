package com.nekogee.muses.repository;

import com.nekogee.muses.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<SysUser, Integer> {

    SysUser findUserByUid(long uid);

    SysUser findUserByPhone(String phone);

    SysUser findUserByEmail(String email);

    SysUser findUserByUsername(String username);

    List<SysUser> findSysUsersByAlias(String Alias);

}
