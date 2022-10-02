package com.ncyteng.zhineng.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.ncyteng.zhineng.pojo.Element;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ElementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Element record);

    int insertSelective(Element record);

    Element selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Element record);

    int updateByPrimaryKey(Element record);

    List<Element> selectByAll(Element element);


}