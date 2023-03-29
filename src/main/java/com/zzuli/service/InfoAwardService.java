package com.zzuli.service;

import com.zzuli.po.InfoAward;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzuli.vo.InfoAwardVo;

import java.util.List;

/**
* @author 86136
* @description 针对表【info_award】的数据库操作Service
* @createDate 2023-03-14 20:52:59
*/
public interface InfoAwardService extends IService<InfoAward> {
    int saveInfoAward(InfoAward infoAward);
    InfoAwardVo selectById(Integer  AwardId);
    List<InfoAwardVo> selectAll();
    void updateSate(Integer awardId);
    List<InfoAwardVo> getDepAward();
    List<InfoAwardVo> getCheckedAward();
}
