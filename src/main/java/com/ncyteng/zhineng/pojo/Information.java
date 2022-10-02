package com.ncyteng.zhineng.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com-ncyteng-zhineng-pojo-Information")
public class Information {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 地址
    */
    @ApiModelProperty(value="地址")
    private String location;

    /**
    * 电话
    */
    @ApiModelProperty(value="电话")
    private String photo;

    /**
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 座机
    */
    @ApiModelProperty(value="座机")
    private String landline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", photo='" + photo + '\'' +
                ", email='" + email + '\'' +
                ", landline='" + landline + '\'' +
                '}';
    }
}