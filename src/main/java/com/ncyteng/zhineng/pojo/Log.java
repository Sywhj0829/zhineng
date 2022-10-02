package com.ncyteng.zhineng.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com-ncyteng-zhineng-pojo-Log")
public class Log {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * ip地址
    */
    @ApiModelProperty(value="ip地址")
    private String ip;

    /**
    * 登录时间
    */
    @ApiModelProperty(value="登录时间")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Log(Integer id, String ip, String time) {
        this.id = id;
        this.ip = ip;
        this.time = time;
    }
}