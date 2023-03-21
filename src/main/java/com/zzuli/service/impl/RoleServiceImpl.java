package com.zzuli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.po.Role;
import com.zzuli.service.RoleService;
import com.zzuli.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 86136
* @description 针对表【role】的数据库操作Service实现
* @createDate 2023-03-14 20:53:03
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




