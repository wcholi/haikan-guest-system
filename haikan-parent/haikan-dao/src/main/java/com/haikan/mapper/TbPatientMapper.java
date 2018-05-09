package com.haikan.mapper;

import com.haikan.pojo.TbPatient;
import com.haikan.pojo.TbPatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPatientMapper {
    int countByExample(TbPatientExample example);

    int deleteByExample(TbPatientExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbPatient record);

    int insertSelective(TbPatient record);

    List<TbPatient> selectByExample(TbPatientExample example);

    TbPatient selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbPatient record, @Param("example") TbPatientExample example);

    int updateByExample(@Param("record") TbPatient record, @Param("example") TbPatientExample example);

    int updateByPrimaryKeySelective(TbPatient record);

    int updateByPrimaryKey(TbPatient record);
}