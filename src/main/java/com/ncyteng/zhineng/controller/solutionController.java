package com.ncyteng.zhineng.controller;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.News;
import com.ncyteng.zhineng.pojo.Solution;
import com.ncyteng.zhineng.service.NewsService;
import com.ncyteng.zhineng.service.SolutionService;
import com.ncyteng.zhineng.tools.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/admin/solution")
public class solutionController {

    /**
     * 关于新闻的界面
     */
    @Resource
    private SolutionService solutionService;

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "back/solution/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultJson add(Solution solution){
        solutionService.insertSelective(solution);
        return ResultJson.success("ok");
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
        Solution solution = solutionService.selectByPrimaryKey(id);
        model.addAttribute("solution",solution);
        return "back/solution/update";
    }

    @PostMapping("/update")
    @ResponseBody
    public ResultJson update( Solution solution) {
        solutionService.updateByPrimaryKey(solution);
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
        Solution solution = solutionService.selectByPrimaryKey(id);
        model.addAttribute("solution",solution);
        return "back/solution/see";
    }


    /**
     * 传递id 实现删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultJson delete(Integer id){
        solutionService.deleteByPrimaryKey(id);
        return  ResultJson.success("ok");
    }

    /**
     * 查询页面
     * @return
     */
    @GetMapping("/list")
    public String list(){
        return "back/solution/list";
    }
    @PostMapping("/list")
    @ResponseBody
    public ResultJson list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "5") int size,
                           Solution solution){
        PageInfo<Solution> info = solutionService.selectByAllwithPage(page, size, solution);
        return ResultJson.success("查询成功",info.getList(),(int) info.getTotal());
    }
}
