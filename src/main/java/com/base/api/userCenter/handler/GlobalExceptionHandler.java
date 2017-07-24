package com.base.api.userCenter.handler;

import com.base.api.userCenter.model.ResponseData;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ExceptionHandler(value = ChangeSetPersister.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseData noFoundErrorHandler(HttpServletRequest req, Exception ex){
        ResponseData data = new ResponseData();
        data.error("404", ex.getMessage());
        return data;
    }

    @ExceptionHandler(value = java.lang.Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData defaultErr(HttpServletRequest req, Exception ex) {
        ResponseData data = new ResponseData();
        data.error(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
        return data;
    }


}
