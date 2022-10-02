package com.ncyteng.zhineng.controller;

import com.github.pagehelper.PageInfo;
import com.ncyteng.zhineng.pojo.Aboutus;
import com.ncyteng.zhineng.service.AboutusService;
import com.ncyteng.zhineng.tools.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/aboutus")
public class AboutusController {

    /**
     * 关于我们界面
     */
    @Resource
    private AboutusService aboutusService;

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "back/aboutus/add";
    }
    @PostMapping("/add")
    @ResponseBody
    public ResultJson add(Aboutus aboutus){
        aboutusService.insertSelective(aboutus);
        return  ResultJson.success("ok");
    }


    /**
     * 修改页面
     * @return
     * 收到list传过来的id值进行查询然后返回到前端
     */
    @GetMapping("/update")
    public String update(HttpServletRequest request,Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        Aboutus aboutus = aboutusService.selectByPrimaryKey(id);
        model.addAttribute("aboutus",aboutus);
        return "back/aboutus/update";
    }
    @PostMapping("/update")
    @ResponseBody
    public ResultJson update(Aboutus aboutus){
        aboutusService.updateByPrimaryKey(aboutus);
        return  ResultJson.success("ok");
    }

    /**
     * 查看内容页面
     */
    @GetMapping("/see")
    public String see(HttpServletRequest request,Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        Aboutus aboutus = aboutusService.selectByPrimaryKey(id);
        model.addAttribute("aboutus",aboutus);
        return "back/aboutus/see";
    }

    @PostMapping("/see")
    @ResponseBody
    public ResultJson see(Aboutus aboutus){
        aboutusService.updateByPrimaryKey(aboutus);
        return  ResultJson.success("ok");
    }

    /**
     * 删除页面
     * 传递id值
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultJson delete(Integer id){
        aboutusService.deleteByPrimaryKey(id);
        return  ResultJson.success("ok");
    }


    /**
     * 查询页面
     * @return
     */
    @GetMapping("/list")
    public String list(){
        return "back/aboutus/list";
    }
    @PostMapping("/list")
    @ResponseBody
    public ResultJson list(@RequestParam(defaultValue = "2") int page,
                           @RequestParam(defaultValue = "5") int size,
                           Aboutus aboutus){
        PageInfo<Aboutus> info = aboutusService.selectByAllwithPage(page,size, aboutus);
        return  ResultJson.success("查询成功",info.getList(), (int) info.getTotal());
    }
}
