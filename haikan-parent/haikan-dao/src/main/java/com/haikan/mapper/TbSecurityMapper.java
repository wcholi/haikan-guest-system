package com.haikan.mapper;

import com.haikan.pojo.TbSecurity;
import com.haikan.pojo.TbSecurityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSecurityMapper {
    int countByExample(TbSecurityExample example);

    int deleteByExample(TbSecurityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSecurity record);

    int insertSelective(TbSecurity record);

    List<TbSecurity> selectByExample(TbSecurityExample example);

    TbSecurity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSecurity record, @Param("example") TbSecurityExample example);

    int updateByExample(@Param("record") TbSecurity record, @Param("example") TbSecurityExample example);

    int updateByPrimaryKeySelective(TbSecurity record);

    int updateByPrimaryKey(TbSecurity record);
}