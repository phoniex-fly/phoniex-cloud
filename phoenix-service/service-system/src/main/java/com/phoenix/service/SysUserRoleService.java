package com.phoenix.service;

import com.phoenix.domain.SysUserRole;
public interface SysUserRoleService{


    int deleteByPrimaryKey(Long userId,Long roleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

}
