package com.ncyteng.zhineng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ncyteng.zhineng.dao.AdminMapper;
import com.ncyteng.zhineng.pojo.Admin;
import com.ncyteng.zhineng.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    public List<Admin> selectByAll(Admin admin) {
        return adminMapper.selectByAll(admin);
    }

    public PageInfo<Admin> selectByAllwithPage(int page, int pageSize, Admin admin) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(adminMapper.selectByAll(admin));
    }
}
