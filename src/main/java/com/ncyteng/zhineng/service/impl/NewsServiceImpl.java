package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.dao.NewsMapper;
import com.ncyteng.zhineng.pojo.News;
import com.ncyteng.zhineng.service.NewsService;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Resource
    private NewsMapper newsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(News record) {
        return newsMapper.insert(record);
    }

    @Override
    public int insertSelective(News record) {
        return newsMapper.insertSelective(record);
    }

    @Override
    public News selectByPrimaryKey(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(News record) {
        return newsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(News record) {
        return newsMapper.updateByPrimaryKey(record);
    }

    public PageInfo<News> selectByAllwithPage(int page, int pageSize, News news) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(newsMapper.selectByAll(news));
    }

    public List<News> selectByAll(News news) {
        return newsMapper.selectByAll(news);
    }
}
