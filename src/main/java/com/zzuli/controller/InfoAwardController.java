package com.zzuli.controller;

import com.zzuli.po.InfoAward;
import com.zzuli.service.InfoAwardService;
import com.zzuli.utils.Result;
import com.zzuli.vo.InfoAwardVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/award")
public class InfoAwardController {
    @Autowired
    private InfoAwardService infoAwardService;

    @ApiOperation("教师保存奖状")
    @PostMapping("/save")
    public Result saveAward(@RequestBody InfoAward infoAward)
    {
        int i = infoAwardService.saveInfoAward(infoAward);
        if(i==0)return Result.fail("添加失败");
        return Result.ok(infoAward);
    }
    @ApiOperation("查询奖状")
    @GetMapping("/search/{id}")
    public Result selectById(@PathVariable("id") Integer id)
    {
        InfoAwardVo infoAwardVo = infoAwardService.selectById(id);
        System.out.println(infoAwardVo);
        return Result.ok(infoAwardVo);
    }

    @ApiOperation("查询全部奖状")
    @GetMapping("/searchAll")
    public Result selectAll()
    {
        List<InfoAwardVo> infoAwardVos = infoAwardService.selectAll();
        return Result.ok(infoAwardVos);
    }
    @ApiOperation("查询第一步已审核过的奖状")
    @GetMapping("/searchChecked")
    public Result selectChecked()
    {
        List<InfoAwardVo> checkedAward = infoAwardService.getCheckedAward();
        return Result.ok(checkedAward);
    }
    @ApiOperation("查询发送给院级领导的奖状")
    @GetMapping("/Depsearch")
    public Result selectChecking()
    {
        List<InfoAwardVo> depAward = infoAwardService.getDepAward();
        return Result.ok(depAward);
    }
    //todo 查询二级已审核过的奖状  查询发送给二级领导的奖状
}
