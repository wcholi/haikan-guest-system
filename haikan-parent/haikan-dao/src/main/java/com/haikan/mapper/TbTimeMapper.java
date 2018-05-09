package com.haikan.mapper;

import com.haikan.pojo.TbTime;
import com.haikan.pojo.TbTimeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbTimeMapper {
    int countByExample(TbTimeExample example);

    int deleteByExample(TbTimeExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TbTime record);

    int insertSelective(TbTime record);

    List<TbTime> selectByExample(TbTimeExample example);

    TbTime selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TbTime record, @Param("example") TbTimeExample example);

    int updateByExample(@Param("record") TbTime record, @Param("example") TbTimeExample example);

    int updateByPrimaryKeySelective(TbTime record);

    int updateByPrimaryKey(TbTime record);
    
    List<Map> selectTimeList();
}