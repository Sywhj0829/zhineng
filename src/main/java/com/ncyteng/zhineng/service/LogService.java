package com.ncyteng.zhineng.service;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Log;

import java.util.List;

public interface LogService{


    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

    List<Log> selectByAll(Log log);

    public PageInfo<Log> selectByAllwithPage(int page, int pageSize, Log log);
}
