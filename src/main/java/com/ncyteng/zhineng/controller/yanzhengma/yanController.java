package com.ncyteng.zhineng.controller.yanzhengma;

import com.ncyteng.zhineng.tools.yanzhengma;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller

public class yanController {

    //    调用验证码
    @GetMapping("/yanzheng")
    public void yan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        yanzhengma yan = new yanzhengma();
        //调用yan的方法生成验证码图片 方法里面自动跳转
        yan.getRandcode(request,response);
    }
}
