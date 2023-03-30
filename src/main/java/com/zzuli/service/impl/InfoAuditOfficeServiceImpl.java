package com.zzuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.exception.ZzuliException;
import com.zzuli.po.InfoAuditOffice;
import com.zzuli.service.InfoAuditOfficeService;
import com.zzuli.mapper.InfoAuditOfficeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86136
* @description 针对表【info_audit_office】的数据库操作Service实现
* @createDate 2023-03-30 15:24:15
*/
@Service
public class InfoAuditOfficeServiceImpl extends ServiceImpl<InfoAuditOfficeMapper, InfoAuditOffice>
    implements InfoAuditOfficeService{
    @Autowired
    private InfoAuditOfficeMapper infoAuditOfficeMapper;
    @Override
    public int insertCheckForm(Integer AwardId) {
        QueryWrapper<InfoAuditOffice> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("award_id",AwardId);
        InfoAuditOffice infoAudit = infoAuditOfficeMapper.selectOne(QueryWrapper);
        if(infoAudit!=null)
        {
            ZzuliException.cast("该表正在审核中，请不要重复提交");
        }
        InfoAuditOffice infoAuditOffice = new InfoAuditOffice();
        infoAuditOffice.setIsCheck(0);
        infoAuditOffice.setAwardId(AwardId);
        int result = infoAuditOfficeMapper.insert(infoAuditOffice);
        if(result==0)
        {
            ZzuliException.cast("插入审核表失败，请重试");
        }
        return result;
    }

    @Override
    public int updateStatement(Integer awardId) {

        return 0;
    }
}




