package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.pojo.Case;
import com.ncyteng.zhineng.dao.CaseMapper;
import com.ncyteng.zhineng.service.CaseService;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService{

    @Resource
    private CaseMapper caseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return caseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Case record) {
        return caseMapper.insert(record);
    }

    @Override
    public int insertSelective(Case record) {
        return caseMapper.insertSelective(record);
    }

    @Override
    public Case selectByPrimaryKey(Integer id) {
        return caseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Case record) {
        return caseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Case record) {
        return caseMapper.updateByPrimaryKey(record);
    }

    public List<Case> selectByAll(Case record) {
        return caseMapper.selectByAll(record);
    }

    public PageInfo<Case> selectByAllwithPage(int page, int pageSize, Case record) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(caseMapper.selectByAll(record));
    }
}
