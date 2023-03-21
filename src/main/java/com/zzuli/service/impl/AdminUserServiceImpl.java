package com.zzuli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.po.AdminUser;
import com.zzuli.service.AdminUserService;
import com.zzuli.mapper.AdminUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86136
* @description 针对表【admin_user】的数据库操作Service实现
* @createDate 2023-03-14 20:52:50
*/
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser>
    implements AdminUserService{

}




