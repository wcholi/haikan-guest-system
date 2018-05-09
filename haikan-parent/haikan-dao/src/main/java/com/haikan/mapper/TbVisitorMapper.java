package com.haikan.mapper;

import com.haikan.pojo.TbVisitor;
import com.haikan.pojo.TbVisitorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbVisitorMapper {
    int countByExample(TbVisitorExample example);

    int deleteByExample(TbVisitorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbVisitor record);

    int insertSelective(TbVisitor record);

    List<TbVisitor> selectByExample(TbVisitorExample example);

    TbVisitor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbVisitor record, @Param("example") TbVisitorExample example);

    int updateByExample(@Param("record") TbVisitor record, @Param("example") TbVisitorExample example);

    int updateByPrimaryKeySelective(TbVisitor record);

    int updateByPrimaryKey(TbVisitor record);
    
    TbVisitor selectByIdCard(String idCard);
}