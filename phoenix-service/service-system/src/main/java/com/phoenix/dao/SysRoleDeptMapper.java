package com.phoenix.dao;

import com.phoenix.domain.SysRoleDept;
import org.apache.ibatis.annotations.Param;

public interface SysRoleDeptMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("deptId") Long deptId);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);
}