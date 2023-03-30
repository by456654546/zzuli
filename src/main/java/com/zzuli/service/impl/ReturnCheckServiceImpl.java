package com.zzuli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.po.ReturnCheck;
import com.zzuli.service.ReturnCheckService;
import com.zzuli.mapper.ReturnCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86136
* @description 针对表【return_check】的数据库操作Service实现
* @createDate 2023-03-30 10:23:54
*/
@Service
public class ReturnCheckServiceImpl extends ServiceImpl<ReturnCheckMapper, ReturnCheck>
    implements ReturnCheckService{
    @Autowired
    ReturnCheckMapper returnCheckMapper;
    @Override
    public int insertReturnForm(Integer awardId,Integer teacherId,String msg) {
        ReturnCheck returnCheck = new ReturnCheck();
        returnCheck.setAwardId(awardId);
        returnCheck.setTeacherId(teacherId);
        returnCheck.setMessage(msg);
        return returnCheckMapper.insert(returnCheck);
    }
}




