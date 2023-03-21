package com.zzuli.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
