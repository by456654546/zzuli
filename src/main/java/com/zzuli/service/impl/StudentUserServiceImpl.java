package com.zzuli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.po.StudentUser;
import com.zzuli.service.StudentUserService;
import com.zzuli.mapper.StudentUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86136
* @description 针对表【student_user】的数据库操作Service实现
* @createDate 2023-03-14 20:53:08
*/
@Service
public class StudentUserServiceImpl extends ServiceImpl<StudentUserMapper, StudentUser>
    implements StudentUserService{

}




