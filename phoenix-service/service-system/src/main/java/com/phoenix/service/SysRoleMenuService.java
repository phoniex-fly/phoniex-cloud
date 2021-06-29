package com.phoenix.service;

import com.phoenix.domain.SysRoleMenu;
public interface SysRoleMenuService{


    int deleteByPrimaryKey(Long roleId,Long menuId);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

}
