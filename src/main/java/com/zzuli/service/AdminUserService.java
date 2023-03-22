package com.zzuli.service;

import com.zzuli.po.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzuli.vo.AdminUserVo;

/**
* @author 86136
* @description 针对表【admin_user】的数据库操作Service
* @createDate 2023-03-14 20:52:50
*/
public interface AdminUserService extends IService<AdminUser> {
    //添加老师基本信息
    Integer saveAdminUser(AdminUserVo adminuserVo);

    void deletAdminUser(Integer id);

    void updateAdminUser(AdminUserVo adminUserVo);

    AdminUser getAdminUser(Integer id);
}
