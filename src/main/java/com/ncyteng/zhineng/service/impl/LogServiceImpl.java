package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.dao.LogMapper;
import com.ncyteng.zhineng.pojo.Log;
import com.ncyteng.zhineng.service.LogService;

import java.util.List;

@Service
public class LogServiceImpl implements LogService{

    @Resource
    private LogMapper logMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return logMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Log record) {
        return logMapper.insert(record);
    }

    @Override
    public int insertSelective(Log record) {
        return logMapper.insertSelective(record);
    }

    @Override
    public Log selectByPrimaryKey(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Log record) {
        return logMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Log record) {
        return logMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Log> selectByAllwithPage(int page, int pageSize, Log log) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(logMapper.selectByAll(log));
    }

    public List<Log> selectByAll(Log log) {
        return logMapper.selectByAll(log);
    }
}
