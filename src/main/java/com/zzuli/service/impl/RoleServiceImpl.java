package com.zzuli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.po.Role;
import com.zzuli.service.RoleService;
import com.zzuli.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 86136
* @description 针对表【role】的数据库操作Service实现
* @createDate 2023-03-14 20:53:03
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRoles(String ids) {
        List<Integer> list = convertList(ids);
        List<Role> roles = roleMapper.selectBatchIds(list);
        if(roles==null)
        {
            throw new RuntimeException("未查到该用户权限");
        }
        return roles;
    }
    public List<Integer> convertList(String ids)
    {
        List<Integer> l=new ArrayList<>();
        if(!"".equals(ids) && ids !=null)
        {
            String [] idArray=ids.split(",");
            for(int i=0;i<idArray.length;i++)
            {
                l.add(Integer.parseInt(idArray[i]));
            }
        }
        return  l;
    }
}




