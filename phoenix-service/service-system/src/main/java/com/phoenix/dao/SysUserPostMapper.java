package com.phoenix.dao;

import com.phoenix.domain.SysUserPost;
import org.apache.ibatis.annotations.Param;

public interface SysUserPostMapper {
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("postId") Long postId);

    int insert(SysUserPost record);

    int insertSelective(SysUserPost record);
}