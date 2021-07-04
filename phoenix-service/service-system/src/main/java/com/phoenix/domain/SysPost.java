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
    * 岗位信息表
    */
@ApiModel(value="com-phoenix-domain-SysPost")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysPost implements Serializable {
    /**
    * 岗位ID
    */
    @ApiModelProperty(value="岗位ID")
    private Long postId;

    /**
    * 岗位编码
    */
    @ApiModelProperty(value="岗位编码")
    private String postCode;

    /**
    * 岗位名称
    */
    @ApiModelProperty(value="岗位名称")
    private String postName;

    /**
    * 显示顺序
    */
    @ApiModelProperty(value="显示顺序")
    private Integer postSort;

    /**
    * 状态（0正常 1停用）
    */
    @ApiModelProperty(value="状态（0正常 1停用）")
    private String status;

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

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}