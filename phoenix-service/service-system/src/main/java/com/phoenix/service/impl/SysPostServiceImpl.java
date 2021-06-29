package com.phoenix.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.phoenix.dao.SysPostMapper;
import com.phoenix.domain.SysPost;
import com.phoenix.service.SysPostService;
@Service
public class SysPostServiceImpl implements SysPostService{

    @Resource
    private SysPostMapper sysPostMapper;

    @Override
    public int deleteByPrimaryKey(Long postId) {
        return sysPostMapper.deleteByPrimaryKey(postId);
    }

    @Override
    public int insert(SysPost record) {
        return sysPostMapper.insert(record);
    }

    @Override
    public int insertSelective(SysPost record) {
        return sysPostMapper.insertSelective(record);
    }

    @Override
    public SysPost selectByPrimaryKey(Long postId) {
        return sysPostMapper.selectByPrimaryKey(postId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPost record) {
        return sysPostMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPost record) {
        return sysPostMapper.updateByPrimaryKey(record);
    }

}
