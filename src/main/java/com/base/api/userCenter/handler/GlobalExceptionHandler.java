package com.base.api.userCenter.handler;

import com.base.api.userCenter.model.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by menzhongxin on 2017/6/17.
 */
@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseData defErrorHandler(HttpServletRequest req, Exception ex){
        ResponseData data = new ResponseData();
        data.error("0001", ex.getMessage());
        return data;
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseData noFoundErrorHandler(HttpServletRequest req, Exception ex){
        ResponseData data = new ResponseData();
        data.error("404", "404");
        return data;
    }


}
