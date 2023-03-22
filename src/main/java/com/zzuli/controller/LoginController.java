package com.zzuli.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/login")
@RestController
public class LoginController {

    @PostMapping("/success")
    public String login()
    {
        return "登陆成功";
    }
    @GetMapping("/text")
    GlobalExceptionHandler @PreAuthorize("hasRole('ROLE_SEARCH')")
    public String text()
    {
        return "测试成功";
    }
    @GetMapping("/text2")
    @PreAuthorize("hasRole('pp')")
    public String text2()
    {
        return "测试成功2";
    }
}
