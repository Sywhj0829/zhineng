package com.ncyteng.zhineng.service;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Case;

import java.util.List;

public interface CaseService{


    int deleteByPrimaryKey(Integer id);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);

    List<Case> selectByAll(Case record);

    public PageInfo<Case> selectByAllwithPage(int page, int pageSize, Case record);

}
