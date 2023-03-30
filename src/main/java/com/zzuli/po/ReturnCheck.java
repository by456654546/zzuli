package com.zzuli.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName return_check
 */
@TableName(value ="return_check")
@Data
@ToString
public class ReturnCheck implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 对应奖状id
     */
    @TableField(value = "award_id")
    private Integer awardId;

    /**
     * 对应老师名
     */
    @TableField(value = "teacher_id")
    private Integer teacherId;

    /**
     * 退回原因
     */
    @TableField(value = "message")
    private String message;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}