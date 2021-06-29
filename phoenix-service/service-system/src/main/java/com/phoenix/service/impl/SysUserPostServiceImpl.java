package com.phoenix.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.phoenix.dao.SysUserPostMapper;
import com.phoenix.domain.SysUserPost;
import com.phoenix.service.SysUserPostService;
@Service
public class SysUserPostServiceImpl implements SysUserPostService{

    @Resource
    private SysUserPostMapper sysUserPostMapper;

    @Override
    public int deleteByPrimaryKey(Long userId,Long postId) {
        return sysUserPostMapper.deleteByPrimaryKey(userId,postId);
    }

    @Override
    public int insert(SysUserPost record) {
        return sysUserPostMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserPost record) {
        return sysUserPostMapper.insertSelective(record);
    }

}
