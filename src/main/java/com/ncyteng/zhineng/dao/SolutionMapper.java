package com.ncyteng.zhineng.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.ncyteng.zhineng.pojo.Solution;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SolutionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Solution record);

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKey(Solution record);

    List<Solution> selectByAll(Solution solution);


}