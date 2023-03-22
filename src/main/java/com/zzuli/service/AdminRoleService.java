package com.zzuli.service;

import com.zzuli.po.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

/**
* @author 86136
* @description 针对表【admin_role】的数据库操作Service
* @createDate 2023-03-14 20:52:45
*/
public interface AdminRoleService extends IService<AdminRole> {
    List<AdminRole> getRoles(String ids);
}
