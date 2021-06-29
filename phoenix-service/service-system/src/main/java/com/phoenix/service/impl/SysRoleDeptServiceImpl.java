package com.phoenix.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.phoenix.dao.SysRoleDeptMapper;
import com.phoenix.domain.SysRoleDept;
import com.phoenix.service.SysRoleDeptService;
@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService{

    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;

    @Override
    public int deleteByPrimaryKey(Long roleId,Long deptId) {
        return sysRoleDeptMapper.deleteByPrimaryKey(roleId,deptId);
    }

    @Override
    public int insert(SysRoleDept record) {
        return sysRoleDeptMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleDept record) {
        return sysRoleDeptMapper.insertSelective(record);
    }

}
