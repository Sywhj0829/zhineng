package com.ncyteng.zhineng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ncyteng.zhineng.dao")
public class ZhinengApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhinengApplication.class, args);
    }

}
