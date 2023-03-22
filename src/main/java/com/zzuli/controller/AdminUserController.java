package com.zzuli.controller;

import com.zzuli.mapper.AdminUserMapper;
import com.zzuli.po.AdminUser;
import com.zzuli.service.AdminUserService;
import com.zzuli.utils.Result;
import com.zzuli.vo.AdminUserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/adminuser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @ApiOperation("添加教师基本信息")
    @PostMapping("save")
    public Result saveAdminUser(@RequestBody AdminUserVo adminUserVo) {
         adminUserService.saveAdminUser(adminUserVo);
         return Result.ok("添加教师信息成功");
    }
    @ApiOperation("删除教师")
    @PostMapping("remove/{id}")
    public void deletAdminUserById(@PathVariable Integer id) {
        adminUserService.deletAdminUser(id);

    }
    @ApiOperation("修改教师基本信息")
    @PostMapping("update")
    public void updateAdminUser(@RequestBody AdminUserVo adminUserVo) {
    adminUserService.updateAdminUser(adminUserVo);
    }
    @ApiOperation("根据id查询教师基本信息")
    @PostMapping("get/{id}")
    public Result selectAdminUserById(@PathVariable Integer id) {
    AdminUser adminUser=adminUserService.getAdminUser(id);
       return Result.ok(adminUser);
    }

}
