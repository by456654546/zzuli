package com.zzuli.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.exception.ZzuliException;
import com.zzuli.po.InfoAward;
import com.zzuli.service.InfoAuditService;
import com.zzuli.service.InfoAwardService;
import com.zzuli.mapper.InfoAwardMapper;
import com.zzuli.vo.InfoAwardVo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzuli.utils.SystemState;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author 86136
* @description 针对表【info_award】的数据库操作Service实现
* @createDate 2023-03-14 20:52:59
*/
@Service
public class InfoAwardServiceImpl extends ServiceImpl<InfoAwardMapper,InfoAward>
    implements InfoAwardService{
    @Autowired
    private InfoAwardMapper infoAwardMapper;
    @Override
    @Transactional
    public int saveInfoAward(InfoAward infoAward) {
        //1.校验参数
        if(infoAward.getCollege()==null)
        {
            ZzuliException.cast("学院信息不能为空");
        }
        if(infoAward.getCompetitionName()==null)
        {
            ZzuliException.cast("竞赛名称不能为空");
        }
        if(infoAward.getHoldUnit()==null)
        {
            ZzuliException.cast("举办单位不能为空");
        }
        if(infoAward.getForm()==null)
        {
            ZzuliException.cast("参赛形式不为空");
        }
        if(infoAward.getCategory()==null)
        {
            ZzuliException.cast("奖项类别不能为空");
        }
        if(infoAward.getRaceName()==null)
        {
            ZzuliException.cast("获奖名称不能为空");
        }
        if(infoAward.getGuideTeacher()==null)
        {
            ZzuliException.cast("指导老师不能为空");
        }
        if(infoAward.getStudentName()==null)
        {
            ZzuliException.cast("获奖学生名不能为空");
        }
        infoAward.setIsCheckedDepartment(0);
        infoAward.setIsCheckedOffice(0);
        //2.插入奖状表
        int insert = infoAwardMapper.insert(infoAward);
  //        3.插入审核表1
  //        infoAuditService.insertCheckForm(infoAward.getId());
        return insert;
    }

    @Override
    public InfoAwardVo selectById(Integer AwardId) {
        InfoAward infoAward = infoAwardMapper.selectById(AwardId);
        InfoAwardVo infoAwardVo = new InfoAwardVo();
        BeanUtil.copyProperties(infoAward,infoAwardVo, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        return infoAwardVo;
    }

    @Override
    public List<InfoAwardVo> selectAll() {
        List<InfoAward> infoAwards = infoAwardMapper.selectList(null);
        if(infoAwards==null)
        {
            ZzuliException.cast("未查询到信息");
        }
        List<InfoAwardVo> infoAwardVos = new ArrayList<>();
        for (InfoAward infoAward : infoAwards) {
            InfoAwardVo infoAwardVo = new InfoAwardVo();
            BeanUtil.copyProperties(infoAward,infoAwardVo);
            infoAwardVos.add(infoAwardVo);
        }
        return infoAwardVos;
    }

    @Override
    public void updateSate(Integer awardId,String msg) {
        InfoAward infoAward = infoAwardMapper.selectById(awardId);
        switch (msg)
        {
            case SystemState.CHECK_FORM_FIRST:infoAward.setIsCheckedDepartment(2);break;
            case SystemState.CHECK_FORM_SECOND:infoAward.setIsCheckedOffice(2);break;
            case SystemState.SEND_CHECK_FORM_FIRST:infoAward.setIsCheckedDepartment(1);break;
            case SystemState.SEND_CHECK_FORM_SECOND:infoAward.setIsCheckedOffice(1);break;
            case SystemState.FAIL_CHECK:{
                infoAward.setIsCheckedOffice(0);
                infoAward.setIsCheckedDepartment(0);
                break;
            }
        }

        int i = infoAwardMapper.updateById(infoAward);
        if(i==0)
            ZzuliException.cast("修改状态失败");
    }

    @Override
    public List<InfoAwardVo> getDepAward() {
        List<InfoAwardVo> depAward = infoAwardMapper.getDepAward();
        return depAward;
    }

    @Override
    public List<InfoAwardVo> getCheckedAward() {
        List<InfoAwardVo> checkedAward = infoAwardMapper.getCheckedAward();
        return checkedAward;
    }

}




