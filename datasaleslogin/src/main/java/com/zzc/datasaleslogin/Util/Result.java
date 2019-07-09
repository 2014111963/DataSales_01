package com.zzc.datasaleslogin.Util;

public class Result<T> {
    //返回信息
    private String msg;
    //数据是否正常请求
    private boolean success;

    private String token;
    //具体返回的数据
    private T detail;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}