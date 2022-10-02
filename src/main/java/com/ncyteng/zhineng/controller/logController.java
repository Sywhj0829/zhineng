package com.ncyteng.zhineng.controller;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Log;
import com.ncyteng.zhineng.pojo.News;
import com.ncyteng.zhineng.service.LogService;
import com.ncyteng.zhineng.tools.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/log")
public class logController {


    @Resource
    private LogService logService;


    /**
     * 查询页面
     * @return
     */
    @GetMapping("/list")
    public String list(){
        return "back/log/list";
    }
    @PostMapping("/list")
    @ResponseBody
    public ResultJson list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "5") int size,
                           Log log){
        PageInfo<Log> info = logService.selectByAllwithPage(page, size, log);
        return ResultJson.success("查询成功",info.getList(),(int) info.getTotal());
    }
}
