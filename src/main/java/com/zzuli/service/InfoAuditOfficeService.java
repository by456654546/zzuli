package com.zzuli.service;

import com.zzuli.po.InfoAuditOffice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86136
* @description 针对表【info_audit_office】的数据库操作Service
* @createDate 2023-03-30 15:24:15
*/
public interface InfoAuditOfficeService extends IService<InfoAuditOffice> {
     int insertCheckForm(Integer AwardId);
     int updateStatement(Integer awardId);
}
