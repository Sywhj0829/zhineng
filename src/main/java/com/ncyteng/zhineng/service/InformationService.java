package com.ncyteng.zhineng.service;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Information;

import java.util.List;

public interface InformationService{


    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

    List<Information> selectByAll(Information information);

    public PageInfo<Information> selectByAllwithPage(int page, int pageSize, Information information);
}
