package com.zzuli.mapper;

import com.zzuli.po.InfoAward;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzuli.vo.InfoAwardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 86136
* @description 针对表【info_award】的数据库操作Mapper
* @createDate 2023-03-14 20:52:59
* @Entity generator.domain.InfoAward
*/
@Mapper
public interface InfoAwardMapper extends BaseMapper<InfoAward> {
    List<InfoAwardVo> getDepAward();
    List<InfoAwardVo> getCheckedAward();
}




