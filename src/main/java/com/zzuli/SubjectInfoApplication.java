package com.zzuli;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@MapperScan("com.zzuli.mapper")
public class SubjectInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectInfoApplication.class, args);
    }

}
