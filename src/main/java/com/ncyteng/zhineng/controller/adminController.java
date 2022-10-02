package com.ncyteng.zhineng.controller;


import com.ncyteng.zhineng.pojo.Aboutus;
import com.ncyteng.zhineng.pojo.Admin;
import com.ncyteng.zhineng.pojo.Log;
import com.ncyteng.zhineng.service.AdminService;
import com.ncyteng.zhineng.service.LogService;
import com.ncyteng.zhineng.tools.ResultJson;
import com.ncyteng.zhineng.tools.yanzhengma;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Api(tags = "管理人员")
public class adminController {

    @Resource
    private AdminService adminService;

    @Resource
    private LogService logService;


//    跳转登录页面
    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    //    验证用户登录信息 跳转首页 给session赋值
    @PostMapping("/login")
    @ResponseBody
    public ResultJson login(HttpServletRequest request, Admin admin){
        List<Admin> admins = adminService.selectByAll(admin);
        String yanzhengma = request.getParameter("yanzhengma").toUpperCase();
        String sessionYanzhengma = (String) request.getSession().getAttribute("CHECKCODE");
        if (admins.size()!=1){//数据不对或者没有
            return ResultJson.success("登录失败",0);
        }else if (sessionYanzhengma.equals(yanzhengma)==false){
            return  ResultJson.success("登录失败","0");
        }
        //        添加到session 值 用于 入库 出库 时的记录
        HttpSession session = request.getSession();
        session.setAttribute("username",admin.getUsername());
        Admin admin1 = admins.get(0);
        session.setAttribute("id",admin1.getId());

        //        登录成功 就进行登录日志的添加
//        获取ip地址
        String ip = "";
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                ip = XFor.substring(0,index);
            }else{
                ip = XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            ip = XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        ip = XFor;
//  得到ip

//        构造ip 对象
        long date = System.currentTimeMillis();
        String time = String.valueOf(date);
//        取前面10位才能正常
        Log log = new Log(admin1.getId(),ip,time);
//      插入ip地址
        int i = logService.insertSelective(log);
        return  ResultJson.success("登录成功",1);
    }


//    跳转到主页面
    @GetMapping("/back")
    public String check(HttpServletRequest request, Model model){
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "admin/back";
    }


    /**
     * 修改页面
     * @return
     * 收到list传过来的id值进行查询然后返回到前端
     */
    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model){
        Integer id = (Integer) request.getSession().getAttribute("id");
        Admin admin = adminService.selectByPrimaryKey(id);
        model.addAttribute("admin",admin);
        return "back/admin/update";
    }
    @PostMapping("/update")
    @ResponseBody
    public ResultJson update(Admin admin){
//        将想要修改的admin 取出用户名 如果存在 就不能修改
       Admin admin1=  new Admin();
       admin1.setUsername(admin.getUsername());
        List<Admin> admins = adminService.selectByAll(admin1);
        if (admins.size()==1){//数据不对或者没有
            return ResultJson.success("登录失败",0);
        }
        adminService.updateByPrimaryKey(admin);
        return  ResultJson.success("ok");
    }


    /**
     * 添加页面
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "back/admin/add";
    }
    @PostMapping("/add")
    @ResponseBody
    public ResultJson add(Admin admin){
        Admin admin1=  new Admin();
        admin1.setUsername(admin.getUsername());
        List<Admin> admins = adminService.selectByAll(admin1);
        if (admins.size()==1){//数据不对或者没有
            return ResultJson.success("登录失败",0);
        }
        adminService.insertSelective(admin);
        return  ResultJson.success("ok");
    }
}
