package com.ncyteng.zhineng.tools;


public class ResultJson {
    private Integer code;
    private String msg;
    private Object data;
    private Integer count;

    public ResultJson(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultJson(Integer code, String msg, Object data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public ResultJson() {
    }

    public static ResultJson success(Object data){
        return new ResultJson(status.SUCCESS.getCode(),status.SUCCESS.getMsg(),data);
    }

    public static ResultJson success(String msg, Object data){
        return new ResultJson(status.SUCCESS.getCode(),status.SUCCESS.getMsg(),data);
    }
    public static ResultJson success(String msg, Object data, Integer count){
        return new ResultJson(status.SUCCESS.getCode(),msg,data,count);
    }

    public static ResultJson fail(){
        return new ResultJson(status.FAIL.getCode(),status.FAIL.getMsg(),null);
    }

    public static ResultJson fail(String msg){
        return new ResultJson(status.FAIL.getCode(),status.FAIL.getMsg(),null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

