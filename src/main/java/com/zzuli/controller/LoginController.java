package com.zzuli.controller;
import io.swagger.annotations.Api;
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
@Api(value = "登录",tags = "登录接口")
public class LoginController {

    @PostMapping("/success")
    public String login()
    {
        return "登陆成功";
    }
}
