package com.zzuli.controller;

import com.zzuli.service.InfoAuditService;
import com.zzuli.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    private InfoAuditService auditService;

    @GetMapping("/depAudit/{awardId}")
    @ApiOperation("发送审核表")
    public Result depAudit(@PathVariable("awardId") Integer awardId) {
        int result = auditService.insertCheckForm(awardId);
        if (result == 0) {
            return Result.fail("插入审核表失败");
        }
        return Result.ok();
    }
    //todo 审核成功接口 和 审核失败接口
    @ApiOperation("领导审核")
    @GetMapping("/depAudit/{awardId}/success")
    public Result depAuditIng(@PathVariable("awardId") Integer awardId)
    {

        return null;
    }
}
