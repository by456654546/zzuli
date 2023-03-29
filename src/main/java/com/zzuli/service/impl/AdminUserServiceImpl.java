package com.zzuli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.po.AdminUser;
import com.zzuli.service.AdminUserService;
import com.zzuli.mapper.AdminUserMapper;
import com.zzuli.vo.AdminUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86136
* @description 针对表【admin_user】的数据库操作Service实现
* @createDate 2023-03-14 20:52:50
*/
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService{

    @Autowired
    private AdminUserMapper adminUserMapper;
    @Override
    public Integer saveAdminUser(AdminUserVo adminuserVo) {
        AdminUser adminUser=new AdminUser();
        BeanUtils.copyProperties(adminuserVo,adminUser);
        adminUserMapper.insert(adminUser);
        //设置老师权限
        adminUser.setRolesId("1");
        return adminUser.getId();
    }

    @Override
    public void deletAdminUser(Integer id) {
        adminUserMapper.deleteById(id);
    }

    @Override
    public void updateAdminUser(AdminUserVo adminUserVo) {
        AdminUser adminUser=new AdminUser();
        BeanUtils.copyProperties(adminUserVo,adminUser);
        adminUserMapper.updateById(adminUser);

    }

    @Override
    public AdminUser getAdminUser(Integer id) {
        return adminUserMapper.selectById(id);
    }

}




