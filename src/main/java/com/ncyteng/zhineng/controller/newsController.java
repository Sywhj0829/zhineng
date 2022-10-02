package com.ncyteng.zhineng.controller;



import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.News;
import com.ncyteng.zhineng.service.NewsService;
import com.ncyteng.zhineng.tools.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin/news")
@Controller
public class newsController {


    /**
     * 关于新闻的界面
     */
    @Resource
    private NewsService newsService;

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "back/news/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultJson add(News news){
        System.out.println(news);
        newsService.insertSelective(news);
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
        News news = newsService.selectByPrimaryKey(id);
        model.addAttribute("news",news);
        return "back/news/update";
    }

    @PostMapping("/update")
    @ResponseBody
    public ResultJson update(News news) {
    newsService.updateByPrimaryKey(news);
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
        News news = newsService.selectByPrimaryKey(id);
        model.addAttribute("news",news);
        return "back/news/see";
    }


    /**
     * 传递id 实现删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultJson delete(Integer id){
        newsService.deleteByPrimaryKey(id);
        return  ResultJson.success("ok");
    }

    /**
     * 查询页面
     * @return
     */
    @GetMapping("/list")
    public String list(){
        return "back/news/list";
    }
    @PostMapping("/list")
    @ResponseBody
    public ResultJson list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "5") int size,
                           News news){
        PageInfo<News> info = newsService.selectByAllwithPage(page, size, news);
        return ResultJson.success("查询成功",info.getList(),(int) info.getTotal());
    }
}
