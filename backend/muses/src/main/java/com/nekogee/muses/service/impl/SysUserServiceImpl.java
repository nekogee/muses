package com.nekogee.muses.service.impl;

import com.nekogee.muses.entity.SysUser;
import com.nekogee.muses.repository.UserRepository;
import com.nekogee.muses.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public SysUser findUserByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userRepository.findUserByUsername(username);
    }

    @Override
    public SysUser findUserByPhone(String phone) {
        System.out.println("UserInfoServiceImpl.findUserByPhone()");
        return userRepository.findUserByPhone(phone);
    }

    @Override
    public SysUser findUserByEmail(String email) {
        System.out.println("UserInfoServiceImpl.findUserByEmail()");
        return userRepository.findUserByEmail(email);
    }
}