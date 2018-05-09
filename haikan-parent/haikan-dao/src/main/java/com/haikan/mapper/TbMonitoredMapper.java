package com.haikan.mapper;

import com.haikan.pojo.TbMonitored;
import com.haikan.pojo.TbMonitoredExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMonitoredMapper {
    int countByExample(TbMonitoredExample example);

    int deleteByExample(TbMonitoredExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbMonitored record);

    int insertSelective(TbMonitored record);

    List<TbMonitored> selectByExample(TbMonitoredExample example);

    TbMonitored selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbMonitored record, @Param("example") TbMonitoredExample example);

    int updateByExample(@Param("record") TbMonitored record, @Param("example") TbMonitoredExample example);

    int updateByPrimaryKeySelective(TbMonitored record);

    int updateByPrimaryKey(TbMonitored record);
}