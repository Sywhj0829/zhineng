package com.ncyteng.zhineng.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.ncyteng.zhineng.pojo.Case;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);

    List<Case> selectByAll(Case record);


}