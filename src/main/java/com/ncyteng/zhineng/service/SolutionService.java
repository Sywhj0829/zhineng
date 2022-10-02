package com.ncyteng.zhineng.service;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Solution;

import java.util.List;

public interface SolutionService{


    int deleteByPrimaryKey(Integer id);

    int insert(Solution record);

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKey(Solution record);

    List<Solution> selectByAll(Solution solution);

    public PageInfo<Solution> selectByAllwithPage(int page, int pageSize, Solution solution) ;

}
