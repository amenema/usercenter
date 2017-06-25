package com.base.api.userCenter.model;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by menzhongxin on 2017/6/15.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class ResponseData {
    private String code;
    private String businessCode;
    private String message;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void success(Object data){
        this.code = "0";
        this.businessCode = "0000";
        this.data = data;
    }

    public void error(String businessCode, String msg){
        this.code ="-1";
        this.businessCode = businessCode;
        this.message = msg;
    }
}
