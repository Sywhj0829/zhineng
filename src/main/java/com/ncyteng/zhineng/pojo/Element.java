package com.ncyteng.zhineng.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com-ncyteng-zhineng-pojo-Element")
public class Element {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 是否为ture，是就展示在官网
    */
    @ApiModelProperty(value="是否为ture，是就展示在官网")
    private String type;

    /**
    * 官网展示的元素标题
    */
    @ApiModelProperty(value="官网展示的元素标题")
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}