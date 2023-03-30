package com.zzuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.exception.ZzuliException;
import com.zzuli.mapper.InfoAuditOfficeMapper;
import com.zzuli.po.InfoAudit;
import com.zzuli.po.InfoAuditOffice;
import com.zzuli.po.ReturnCheck;
import com.zzuli.service.InfoAuditOfficeService;
import com.zzuli.service.InfoAuditService;
import com.zzuli.mapper.InfoAuditMapper;
import com.zzuli.service.InfoAwardService;
import com.zzuli.service.ReturnCheckService;
import com.zzuli.vo.InfoAwardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zzuli.utils.SystemState;
import javax.annotation.Resource;
import java.util.Date;

/**
* @author 86136
* @description 针对表【info_audit】的数据库操作Service实现
* @createDate 2023-03-14 20:52:54
*/
@Service
public class InfoAuditServiceImpl extends ServiceImpl<InfoAuditMapper, InfoAudit>
    implements InfoAuditService{
    @Autowired
    private InfoAuditMapper infoAuditMapper;
    @Resource
    private InfoAwardService awardService;
    @Resource
    private ReturnCheckService returnCheckService;
    @Resource
    private InfoAuditOfficeService infoAuditOfficeService;
    /**
     * 发送审核表，修改原表字段
     * @param AwardId
     * @return
     */
    @Override
    @Transactional
    public int insertCheckForm(Integer AwardId) {
        InfoAudit infoAudit = getInfoAudit(AwardId);
        if(infoAudit!=null)
        {
            ZzuliException.cast("该表正在审核中，请不要重复提交");
        }
        InfoAudit curAudit = new InfoAudit();
        curAudit.setAwardId(AwardId);
        curAudit.setIsCheck(0);
        curAudit.setCreateTime(new Date());
        int insert = infoAuditMapper.insert(curAudit);
        awardService.updateSate(AwardId,SystemState.SEND_CHECK_FORM_FIRST);
        return insert;
    }

    /**
     * 审核成功
     * @param awardId
     * @return
     */
    @Override
    @Transactional
    public int CheckSuccess(Integer awardId) {
        //1.查询奖状参数，更改审核表信息
        InfoAudit infoAudit = getInfoAudit(awardId);
        if(infoAudit==null)
        {
            ZzuliException.cast("未查到该表，请重试");
        }
        infoAudit.setIsCheck(1);
        infoAudit.setUpdateTime(new Date());
        int i = infoAuditMapper.updateById(infoAudit);
        //2.更改奖状信息
        awardService.updateSate(awardId,SystemState.CHECK_FORM_FIRST);
        //3.发送教务处审核表
        infoAuditOfficeService.insertCheckForm(awardId);
        //4.暂定 思考是否需要修改office_check字段为1
        return i;
    }

    private InfoAudit getInfoAudit(Integer awardId) {
        QueryWrapper<InfoAudit> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("award_id", awardId);
        return infoAuditMapper.selectOne(QueryWrapper);
    }
    private InfoAuditOffice getInfoAuditOffice(Integer awardId){
        QueryWrapper<InfoAuditOffice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("award_id",awardId);
        return infoAuditOfficeService.getById(awardId);
    }
    /**
     * 审核失败
     * @param returnCheck
     * @return
     */
    @Override
    public int CheckFail(ReturnCheck returnCheck){
        InfoAudit infoAudit = getInfoAudit(returnCheck.getAwardId());
        if(infoAudit==null)
        {
            ZzuliException.cast("未查到该表，请重试");
        }
        infoAudit.setIsCheck(0);
        infoAudit.setUpdateTime(new Date());
        infoAuditMapper.updateById(infoAudit);
        awardService.updateSate(returnCheck.getAwardId(),SystemState.FAIL_CHECK);
        int i = returnCheckService.insertReturnForm(returnCheck.getAwardId(), returnCheck.getTeacherId(), returnCheck.getMessage());
        return i;
    }

    @Override
    @Transactional
    public int OfficeCheckSuccess(Integer awardId) {
        InfoAuditOffice infoAudit = getInfoAuditOffice(awardId);
        if(infoAudit==null)
        {
            ZzuliException.cast("未查到该表，请重试");
        }
        infoAudit.setIsCheck(1);
        infoAudit.setUpdateTime(new Date());
        boolean b = infoAuditOfficeService.updateById(infoAudit);
        if(b==false)
            ZzuliException.cast("修改审核表信息失败");
        awardService.updateSate(awardId,SystemState.CHECK_FORM_SECOND);
        return 1;
    }

    @Override
    public int OfficeCheckFail(ReturnCheck returnCheck) {
        InfoAuditOffice infoAudit = getInfoAuditOffice(returnCheck.getAwardId());
        if(infoAudit==null)
        {
            ZzuliException.cast("未查到该表，请重试");
        }
        infoAudit.setIsCheck(0);
        infoAudit.setUpdateTime(new Date());
        boolean b = infoAuditOfficeService.updateById(infoAudit);
        awardService.updateSate(returnCheck.getAwardId(),SystemState.FAIL_CHECK);
        int i = returnCheckService.insertReturnForm(returnCheck.getAwardId(), returnCheck.getTeacherId(), returnCheck.getMessage());
        return 1;
    }

}




