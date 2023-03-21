package com.zzuli.subjectinfo;

import com.zzuli.mapper.AdminUserMapper;
import com.zzuli.po.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class SubjectInfoApplicationTests {
    @Resource
    AdminUserMapper adminUserMapper;
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("456654546");
        System.out.println(encode);
    }

}
