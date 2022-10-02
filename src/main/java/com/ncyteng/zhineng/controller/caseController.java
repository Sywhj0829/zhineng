package com.ncyteng.zhineng.controller;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Case;
import com.ncyteng.zhineng.service.CaseService;
import com.ncyteng.zhineng.tools.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin/case")
@Controller
public class caseController {


    /**
     * 关于新闻的界面
     */
    @Resource
    private CaseService caseService;

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "back/case/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultJson add(Case c){
        caseService.insertSelective(c);
        return ResultJson.success("ok1");
    }

    /**
     * 修改页面，前端传递id值查询之后数据显示在修改页面
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        Case c = caseService.selectByPrimaryKey(id);
        model.addAttribute("case",c);
        return "back/case/update";
    }

    @PostMapping("/update")
    @ResponseBody
    public ResultJson update(Case c) {
        caseService.updateByPrimaryKey(c);
        return ResultJson.success("ok");
    }


    /**
     *由主页传递id值 查看新闻具体内容，然后
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/see")
    public String see(HttpServletRequest request, Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        Case c = caseService.selectByPrimaryKey(id);
        model.addAttribute("case",c);
        return "back/case/see";
    }
    /**
     * 传递id 实现删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultJson delete(Integer id){
        caseService.deleteByPrimaryKey(id);
        return  ResultJson.success("ok");
    }

    /**
     * 查询页面
     * @return
     */
    @GetMapping("/list")
    public String list(){
        return "back/case/list";
    }
    @PostMapping("/list")
    @ResponseBody
    public ResultJson list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "5") int size,
                           Case c){
        PageInfo<Case> info= caseService.selectByAllwithPage(page, size, c);
        return ResultJson.success("查询成功",info.getList(),(int) info.getTotal());
    }
}
