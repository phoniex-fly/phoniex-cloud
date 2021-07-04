package com.phoenix.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 部门表
    */
@ApiModel(value="com-phoenix-domain-SysDept")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysDept implements Serializable {
    /**
    * 部门id
    */
    @ApiModelProperty(value="部门id")
    private Long deptId;

    /**
    * 父部门id
    */
    @ApiModelProperty(value="父部门id")
    private Long parentId;

    /**
    * 祖级列表
    */
    @ApiModelProperty(value="祖级列表")
    private String ancestors;

    /**
    * 部门名称
    */
    @ApiModelProperty(value="部门名称")
    private String deptName;

    /**
    * 显示顺序
    */
    @ApiModelProperty(value="显示顺序")
    private Integer orderNum;

    /**
    * 负责人
    */
    @ApiModelProperty(value="负责人")
    private String leader;

    /**
    * 联系电话
    */
    @ApiModelProperty(value="联系电话")
    private String phone;

    /**
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 部门状态（0正常 1停用）
    */
    @ApiModelProperty(value="部门状态（0正常 1停用）")
    private String status;

    /**
    * 删除标志（0代表存在 2代表删除）
    */
    @ApiModelProperty(value="删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /**
    * 创建者
    */
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 更新者
    */
    @ApiModelProperty(value="更新者")
    private String updateBy;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}