package com.phoenix.service;

import com.phoenix.domain.SysUserPost;
public interface SysUserPostService{


    int deleteByPrimaryKey(Long userId,Long postId);

    int insert(SysUserPost record);

    int insertSelective(SysUserPost record);

}
