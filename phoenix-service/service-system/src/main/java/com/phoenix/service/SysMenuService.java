package com.phoenix.service;

import com.phoenix.domain.SysMenu;
import com.phoenix.domain.SysUser;

import java.util.List;

public interface SysMenuService {


    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<String> findAuths(SysUser user);

}
