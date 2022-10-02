package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.pojo.Solution;
import com.ncyteng.zhineng.dao.SolutionMapper;
import com.ncyteng.zhineng.service.SolutionService;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService{

    @Resource
    private SolutionMapper solutionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return solutionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Solution record) {
        return solutionMapper.insert(record);
    }

    @Override
    public int insertSelective(Solution record) {
        return solutionMapper.insertSelective(record);
    }

    @Override
    public Solution selectByPrimaryKey(Integer id) {
        return solutionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Solution record) {
        return solutionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Solution record) {
        return solutionMapper.updateByPrimaryKey(record);
    }

    public List<Solution> selectByAll(Solution solution) {
        return solutionMapper.selectByAll(solution);
    }

    public PageInfo<Solution> selectByAllwithPage(int page, int pageSize, Solution solution) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(solutionMapper.selectByAll(solution));
    }
}
