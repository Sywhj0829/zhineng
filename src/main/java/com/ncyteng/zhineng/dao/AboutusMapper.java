package com.ncyteng.zhineng.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.ncyteng.zhineng.pojo.Aboutus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AboutusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Aboutus record);

    int insertSelective(Aboutus record);

    Aboutus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Aboutus record);

    int updateByPrimaryKey(Aboutus record);

    List<Aboutus> selectByAll(Aboutus aboutus);

}