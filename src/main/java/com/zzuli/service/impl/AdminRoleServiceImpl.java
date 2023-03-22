package com.zzuli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.po.AdminRole;
import com.zzuli.service.AdminRoleService;
import com.zzuli.mapper.AdminRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 86136
* @description 针对表【admin_role】的数据库操作Service实现
* @createDate 2023-03-14 20:52:45
*/
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole>
    implements AdminRoleService{
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Override
    public List<AdminRole> getRoles(String ids) {
        List<Integer> list = convertList(ids);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        List<AdminRole> adminRoles = adminRoleMapper.selectBatchIds(list);
        return adminRoles;
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




