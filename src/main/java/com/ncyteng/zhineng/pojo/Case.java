package com.ncyteng.zhineng.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com-ncyteng-zhineng-pojo-Case")
public class Case {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 类型
    */
    @ApiModelProperty(value="类型")
    private String type;

    /**
    * 发布时间
    */
    @ApiModelProperty(value="发布时间")
    private String time;

    /**
    * 浏览次数
    */
    @ApiModelProperty(value="浏览次数")
    private String view;

    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 成功案例内容
    */
    @ApiModelProperty(value="成功案例内容")
    private String content;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", view='" + view + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}