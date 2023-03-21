package com.zzuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzuli.mapper.AdminUserMapper;
import com.zzuli.po.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetail implements UserDetailsService {
    @Autowired
    AdminUserMapper adminUserMapper;
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<AdminUser> adminUsernQueryWrapper = new QueryWrapper<AdminUser>();
        adminUsernQueryWrapper.eq("user_name",username);
        AdminUser adminUser = adminUserMapper.selectOne(adminUsernQueryWrapper);
        List<SimpleGrantedAuthority> objects = new ArrayList<>();
        String passwordEncode = passwordEncoder.encode(adminUser.getPassword());
        System.out.println(passwordEncode);
        return new User(adminUser.getUserName(),"{bcrypt}" + passwordEncode,objects);
    }
}
