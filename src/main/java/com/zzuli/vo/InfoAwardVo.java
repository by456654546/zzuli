package com.zzuli.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@ToString
@Data
public class InfoAwardVo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学院
     */
    @TableField(value = "college")
    private String college;

    /**
     * 竞赛名称
     */
    @TableField(value = "competition_name")
    private String competitionName;

    /**
     * 举办单位
     */
    @TableField(value = "hold_unit")
    private String holdUnit;

    /**
     * 0 否 团体 1  是个人
     */
    @TableField(value = "form")
    private Integer form;

    /**
     * 奖项类别
     */
    @TableField(value = "category")
    private String category;

    /**
     * 是否为文艺 体育类 0 否 1 是
     */
    @TableField(value = "is_other")
    private Integer isOther;

    /**
     * 获奖等级
     */
    @TableField(value = "award_grade")
    private String awardGrade;

    /**
     * 获奖学生Id
     */
    @TableField(value = "student_name")
    private String studentName;

    /**
     * 指导老师
     */
    @TableField(value = "guide_teacher")
    private String guideTeacher;

    /**
     * 获奖时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 认定级别
     */
    @TableField(value = "rec_grade")
    private String recGrade;

    /**
     * 分值
     */
    @TableField(value = "score")
    private Integer score;
    /**
     * 图片地址
     */
    @TableField(value = "url")
    private String url;
    /**
     * 院级审核
     */
    @TableField(value = "is_checked_department")
    private Integer isCheckedDepartment;
    /**
     * 教务处审核
     */
    @TableField(value = "is_checked_office")
    private Integer isCheckedOffice;
    /**
     * 获奖比赛名称
     */
    @TableField(value = "race_name")
    private String raceName;
    @TableField(value = "teacher_id")
    private Integer teacherId;
}
