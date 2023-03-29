package com.zzuli.service;

import com.zzuli.po.InfoAudit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86136
* @description 针对表【info_audit】的数据库操作Service
* @createDate 2023-03-14 20:52:54
*/
public interface InfoAuditService extends IService<InfoAudit> {
    int insertCheckForm(Integer AwardId);
}
