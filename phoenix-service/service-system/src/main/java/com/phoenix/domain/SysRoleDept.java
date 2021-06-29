package com.phoenix.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 角色和部门关联表
    */
@ApiModel(value="com-phoenix-domain-SysRoleDept")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleDept implements Serializable {
    /**
    * 角色ID
    */
    @ApiModelProperty(value="角色ID")
    private Long roleId;

    /**
    * 部门ID
    */
    @ApiModelProperty(value="部门ID")
    private Long deptId;

    private static final long serialVersionUID = 1L;
}