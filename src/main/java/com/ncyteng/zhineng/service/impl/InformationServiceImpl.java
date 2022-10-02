package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.pojo.Information;
import com.ncyteng.zhineng.dao.InformationMapper;
import com.ncyteng.zhineng.service.InformationService;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService{

    @Resource
    private InformationMapper informationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return informationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Information record) {
        return informationMapper.insert(record);
    }

    @Override
    public int insertSelective(Information record) {
        return informationMapper.insertSelective(record);
    }

    @Override
    public Information selectByPrimaryKey(Integer id) {
        return informationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Information record) {
        return informationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Information record) {
        return informationMapper.updateByPrimaryKey(record);
    }

    public List<Information> selectByAll(Information information) {
        return informationMapper.selectByAll(information);
    }

    public PageInfo<Information> selectByAllwithPage(int page, int pageSize, Information information) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(informationMapper.selectByAll(information));
    }
}
