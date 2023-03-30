package com.zzuli.service;

import com.zzuli.po.ReturnCheck;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86136
* @description 针对表【return_check】的数据库操作Service
* @createDate 2023-03-30 10:23:54
*/
public interface ReturnCheckService extends IService<ReturnCheck> {
    int insertReturnForm(Integer awardId,Integer teacherId,String msg);
}
