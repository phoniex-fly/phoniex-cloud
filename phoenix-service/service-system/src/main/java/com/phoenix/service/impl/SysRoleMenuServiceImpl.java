package com.phoenix.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.phoenix.dao.SysRoleMenuMapper;
import com.phoenix.domain.SysRoleMenu;
import com.phoenix.service.SysRoleMenuService;
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int deleteByPrimaryKey(Long roleId,Long menuId) {
        return sysRoleMenuMapper.deleteByPrimaryKey(roleId,menuId);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertSelective(record);
    }

}
