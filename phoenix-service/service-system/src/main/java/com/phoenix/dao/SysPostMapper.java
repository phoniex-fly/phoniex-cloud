package com.phoenix.dao;

import com.phoenix.domain.SysPost;

public interface SysPostMapper {
    int deleteByPrimaryKey(Long postId);

    int insert(SysPost record);

    int insertSelective(SysPost record);

    SysPost selectByPrimaryKey(Long postId);

    int updateByPrimaryKeySelective(SysPost record);

    int updateByPrimaryKey(SysPost record);
}