package com.zzuli.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(description = "AdminUser")
public class AdminUserVo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @TableField(value = "user_name")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;
    /**
     * 实际名字
     */
    @ApiModelProperty(value = "实际名字")
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 老师对应学院
     */
    @ApiModelProperty(value = "老师对应学院")
    @TableField(value = "college")
    private String college;
    /**
     *
     */

}
