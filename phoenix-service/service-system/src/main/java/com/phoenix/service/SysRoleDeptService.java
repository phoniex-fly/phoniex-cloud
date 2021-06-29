package com.phoenix.service;

import com.phoenix.domain.SysRoleDept;
public interface SysRoleDeptService{


    int deleteByPrimaryKey(Long roleId,Long deptId);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

}
