package com.zzuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzuli.mapper.AdminUserMapper;
import com.zzuli.po.AdminUser;
import com.zzuli.po.Role;
import com.zzuli.service.RoleService;
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
    @Autowired
    RoleService roleService;
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<AdminUser> adminUsernQueryWrapper = new QueryWrapper<AdminUser>();
        adminUsernQueryWrapper.eq("user_name",username);
        AdminUser adminUser = adminUserMapper.selectOne(adminUsernQueryWrapper);
        List<Role> roles = roleService.getRoles(adminUser.getRolesId());
        List<SimpleGrantedAuthority> Authority = new ArrayList<>();
        System.out.println(roles);
        String passwordEncode = passwordEncoder.encode(adminUser.getPassword());
        for (Role role : roles) {
            Authority.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new User(adminUser.getUserName(),"{bcrypt}" + passwordEncode,Authority);
    }
}
