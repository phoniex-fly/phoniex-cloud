package com.phoenix.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 角色和菜单关联表
    */
@ApiModel(value="com-phoenix-domain-SysRoleMenu")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleMenu implements Serializable {
    /**
    * 角色ID
    */
    @ApiModelProperty(value="角色ID")
    private Long roleId;

    /**
    * 菜单ID
    */
    @ApiModelProperty(value="菜单ID")
    private Long menuId;

    private static final long serialVersionUID = 1L;
}