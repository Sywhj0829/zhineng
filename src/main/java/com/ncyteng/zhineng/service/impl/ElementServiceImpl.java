package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.pojo.Element;
import com.ncyteng.zhineng.dao.ElementMapper;
import com.ncyteng.zhineng.service.ElementService;

import java.util.List;

@Service
public class ElementServiceImpl implements ElementService{

    @Resource
    private ElementMapper elementMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return elementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Element record) {
        return elementMapper.insert(record);
    }

    @Override
    public int insertSelective(Element record) {
        return elementMapper.insertSelective(record);
    }

    @Override
    public Element selectByPrimaryKey(Integer id) {
        return elementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Element record) {
        return elementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Element record) {
        return elementMapper.updateByPrimaryKey(record);
    }


    public List<Element> selectByAll(Element element) {
        return elementMapper.selectByAll(element);
    }

    public PageInfo<Element> selectByAllwithPage(int page, int pageSize, Element element) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(elementMapper.selectByAll(element));
    }
}
