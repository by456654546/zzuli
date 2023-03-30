package com.zzuli.controller;

import com.zzuli.po.ReturnCheck;
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
    @ApiOperation("一级领导审核成功")
    @GetMapping("/depAudit/{awardId}/success")
    public Result depAuditIngSuccess(@PathVariable("awardId") Integer awardId)
    {
        int result = auditService.CheckSuccess(awardId);
        if(result==0)
            return Result.fail("审核出现问题，请重试");
        return Result.ok();
    }
    @ApiOperation("一级领导审核失败")
    @PostMapping("/depAudit/fail")
    public Result depAuditIngFail(@RequestBody ReturnCheck returnCheck)
    {
        int result = auditService.CheckFail(returnCheck);
        if(result==0)
            return Result.fail("审核出现问题，请重试");
        return Result.ok();
    }
    @ApiOperation("二级领导审核成功")
    @GetMapping("/offAudit/{awardId}/success")
    public Result offAuditIngSuccess(@PathVariable("awardId") Integer awardId)
    {
        int result = auditService.OfficeCheckSuccess(awardId);
        if(result==0)
            return Result.fail("审核出现问题，请重试");
        return Result.ok();
    }
    @ApiOperation("二级领导审核失败")
    @PostMapping("/offAudit/fail")
    public Result offAuditFail(@RequestBody ReturnCheck returnCheck)
    {
        int result = auditService.OfficeCheckFail(returnCheck);
        if(result==0)
            return Result.fail("审核出现问题，请重试");
        return Result.ok();
    }
}
