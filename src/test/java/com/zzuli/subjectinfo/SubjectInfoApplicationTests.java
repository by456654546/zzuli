package com.zzuli.subjectinfo;

import com.zzuli.mapper.AdminUserMapper;
import com.zzuli.po.Role;
import com.zzuli.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SubjectInfoApplicationTests {
    @Resource
    AdminUserMapper adminUserMapper;
    @Autowired
    RoleService RoleService;
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("456654546");
        System.out.println(encode);
    }
    @Test
    void AdminRoles()
    {
        List<Role> roles = RoleService.getRoles("1,2");
        System.out.println(roles);
    }

}
