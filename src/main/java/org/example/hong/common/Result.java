package org.example.hong.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    public static <T> Result<T> sucess(){
        return sucess(null);
    }
    public static <T> Result<T> sucess(T data){
        Result<T> result=new Result<T>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    public static <T> Result<T> error(int code,String msg){
        Result<T> result=new Result<T>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
    public static <T> Result<T> error(String msg){
        return error(500,msg);
    }

}
