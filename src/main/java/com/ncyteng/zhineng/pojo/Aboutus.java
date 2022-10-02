package com.ncyteng.zhineng.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com-ncyteng-zhineng-pojo-Aboutus")
public class Aboutus {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 关于我们表里面的种类
    */
    @ApiModelProperty(value="关于我们表里面的种类")
    private String typename;

    /**
    * 照片
    */
    @ApiModelProperty(value="照片")
    private String photo;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Aboutus{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", photo='" + photo + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}