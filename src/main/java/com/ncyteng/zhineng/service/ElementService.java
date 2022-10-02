package com.ncyteng.zhineng.service;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Element;

import java.util.List;

public interface ElementService{


    int deleteByPrimaryKey(Integer id);

    int insert(Element record);

    int insertSelective(Element record);

    Element selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Element record);

    int updateByPrimaryKey(Element record);

    List<Element> selectByAll(Element element);

    public PageInfo<Element> selectByAllwithPage(int page, int pageSize, Element element);

}
