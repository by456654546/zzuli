package com.zzuli.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName info_award
 */
@TableName(value ="info_award")
@Data
@ToString
public class InfoAward implements Serializable {
    /**
     * 
     */
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
    /**
     * 对应保存老师的id信息，返回退回消息使用
     */
    @TableField(value = "teacher_id")
    private Integer teacherId;
    /**
     * 
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InfoAward other = (InfoAward) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCollege() == null ? other.getCollege() == null : this.getCollege().equals(other.getCollege()))
            && (this.getCompetitionName() == null ? other.getCompetitionName() == null : this.getCompetitionName().equals(other.getCompetitionName()))
            && (this.getHoldUnit() == null ? other.getHoldUnit() == null : this.getHoldUnit().equals(other.getHoldUnit()))
            && (this.getForm() == null ? other.getForm() == null : this.getForm().equals(other.getForm()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getIsOther() == null ? other.getIsOther() == null : this.getIsOther().equals(other.getIsOther()))
            && (this.getAwardGrade() == null ? other.getAwardGrade() == null : this.getAwardGrade().equals(other.getAwardGrade()))
            && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
            && (this.getGuideTeacher() == null ? other.getGuideTeacher() == null : this.getGuideTeacher().equals(other.getGuideTeacher()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRecGrade() == null ? other.getRecGrade() == null : this.getRecGrade().equals(other.getRecGrade()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCollege() == null) ? 0 : getCollege().hashCode());
        result = prime * result + ((getCompetitionName() == null) ? 0 : getCompetitionName().hashCode());
        result = prime * result + ((getHoldUnit() == null) ? 0 : getHoldUnit().hashCode());
        result = prime * result + ((getForm() == null) ? 0 : getForm().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getIsOther() == null) ? 0 : getIsOther().hashCode());
        result = prime * result + ((getAwardGrade() == null) ? 0 : getAwardGrade().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getGuideTeacher() == null) ? 0 : getGuideTeacher().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRecGrade() == null) ? 0 : getRecGrade().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}