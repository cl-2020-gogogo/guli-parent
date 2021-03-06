package com.atguigu.commonutils;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class R {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> date=new HashMap<String, Object>();
    //构造方法私有化
    private R(){

    }

    //成功方法
    public static  R ok(){
        R r=new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SECCESS);
        r.setMessage("成功");
        return r;
    }
    //失败方法
    public static  R error(){
        R r=new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R date(Map<String, Object>map){
        this.setDate(map);
        return this;
    }
    public R date(String key,Object vue){
        this.date.put(key,vue);
        return this;
    }
}
