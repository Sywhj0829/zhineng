package com.ncyteng.zhineng.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.ncyteng.zhineng.pojo.Information;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

    List<Information> selectByAll(Information information);


}