package com.ncyteng.zhineng.controller.upload;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

@Controller
@RequestMapping("/back")
public class upload {

//   定义照片存放地址 放到application定义里面
    @Value("${uploadPath}")
    private String uploadPath;

    @PostMapping("/upload")
    @ResponseBody
    public HashMap upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString() + ext;
        File targetFile = new File(uploadPath,newName);
        file.transferTo(targetFile);
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("code",0);
        hm.put("msg","添加成功");
        hm.put("name",newName);
        return hm;
    }
}
