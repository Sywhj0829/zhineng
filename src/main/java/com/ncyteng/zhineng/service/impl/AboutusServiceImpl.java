package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.dao.AboutusMapper;
import com.ncyteng.zhineng.pojo.Aboutus;
import com.ncyteng.zhineng.service.AboutusService;

import java.util.List;

@Service
public class AboutusServiceImpl implements AboutusService{

    @Resource
    private AboutusMapper aboutusMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return aboutusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Aboutus record) {
        return aboutusMapper.insert(record);
    }

    @Override
    public int insertSelective(Aboutus record) {
        return aboutusMapper.insertSelective(record);
    }

    @Override
    public Aboutus selectByPrimaryKey(Integer id) {
        return aboutusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Aboutus record) {
        return aboutusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Aboutus record) {
        return aboutusMapper.updateByPrimaryKey(record);
    }

    public List<Aboutus> selectByAll(Aboutus aboutus) {
        return aboutusMapper.selectByAll(aboutus);
    }

    public PageInfo<Aboutus> selectByAllwithPage(int page, int pageSize, Aboutus aboutus) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(aboutusMapper.selectByAll(aboutus));
    }
}
