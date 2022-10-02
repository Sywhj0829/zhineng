package com.ncyteng.zhineng.service;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Admin;

import java.util.List;

public interface AdminService{


    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectByAll(Admin admin);

    public PageInfo<Admin> selectByAllwithPage(int page, int pageSize, Admin admin);


}
