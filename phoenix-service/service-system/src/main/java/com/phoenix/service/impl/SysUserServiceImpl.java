package com.phoenix.service.impl;

import com.phoenix.dao.SysUserMapper;
import com.phoenix.domain.SysUser;
import com.phoenix.service.AuthUserService;
import com.phoenix.service.SysMenuService;
import com.phoenix.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUser")
public class SysUserServiceImpl implements SysUserService, AuthUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }


    @Override
    public UserDetails findUserByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }

    @Override
    public List<String> findAuths(UserDetails user) {
        return sysMenuService.findAuths((SysUser) user);
    }
}
