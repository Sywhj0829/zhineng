package com.ncyteng.zhineng.controller;

import com.ncyteng.zhineng.service.ElementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/element")
public class elementController {

    /**
     * 首页展示元素
     * 先不搞
     */
    @Resource
    private ElementService elementService;

    /**
     *添加元素
     */
    public String add(){
        return "ok";
    }
}
