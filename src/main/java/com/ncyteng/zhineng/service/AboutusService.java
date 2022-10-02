package com.ncyteng.zhineng.service;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Aboutus;

import java.util.List;

public interface AboutusService{


    int deleteByPrimaryKey(Integer id);

    int insert(Aboutus record);

    int insertSelective(Aboutus record);

    Aboutus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Aboutus record);

    int updateByPrimaryKey(Aboutus record);

    List<Aboutus> selectByAll(Aboutus aboutus);

    public PageInfo<Aboutus> selectByAllwithPage(int page, int pageSize, Aboutus aboutus);

}
