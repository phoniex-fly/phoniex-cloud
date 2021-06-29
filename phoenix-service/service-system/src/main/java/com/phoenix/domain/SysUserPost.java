package com.phoenix.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户与岗位关联表
    */
@ApiModel(value="com-phoenix-domain-SysUserPost")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUserPost implements Serializable {
    /**
    * 用户ID
    */
    @ApiModelProperty(value="用户ID")
    private Long userId;

    /**
    * 岗位ID
    */
    @ApiModelProperty(value="岗位ID")
    private Long postId;

    private static final long serialVersionUID = 1L;
}