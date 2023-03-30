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

    /**
     * 查询所有奖状
     * @return
     */
    List<InfoAwardVo> selectAll();

    /**
     * 修改奖状表的状态
     * @param awardId
     * @param msg
     */
    void updateSate(Integer awardId,String msg);

    /**
     * 查询正在审核的奖状
     * @return
     */
    List<InfoAwardVo> getDepAward();

    /**
     * 查询已经审核过的奖状 用于历史记录
     * @return
     */
    List<InfoAwardVo> getCheckedAward();
}
