package com.zzuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.exception.ZzuliException;
import com.zzuli.po.InfoAudit;
import com.zzuli.service.InfoAuditService;
import com.zzuli.mapper.InfoAuditMapper;
import com.zzuli.service.InfoAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 发送审核表，修改原表字段
     * @param AwardId
     * @return
     */
    @Override
    @Transactional
    public int insertCheckForm(Integer AwardId) {
        QueryWrapper<InfoAudit> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("award_id",AwardId);
        InfoAudit infoAudit = infoAuditMapper.selectOne(QueryWrapper);
        if(infoAudit!=null)
        {
            ZzuliException.cast("该表正在审核中，请不要重复提交");
        }
        InfoAudit curAudit = new InfoAudit();
        curAudit.setAwardId(AwardId);
        curAudit.setIsCheck(0);
        curAudit.setCreateTime(new Date());
        int insert = infoAuditMapper.insert(curAudit);
        awardService.updateSate(AwardId);
        return insert;
    }

}




