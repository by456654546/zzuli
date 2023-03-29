package com.zzuli.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody//将信息返回为 json格式
    @ExceptionHandler(ZzuliException.class)//此方法捕获XueChengPlusException异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//状态码返回500
    public RestErrorResponse doXueChengPlusException(ZzuliException e){

        log.error("捕获异常：{}",e.getErrMessage());
        e.printStackTrace();

        String errMessage = e.getErrMessage();

        return new RestErrorResponse(errMessage);
    }
    //捕获不可预知异常 Exception
    @ResponseBody//将信息返回为 json格式
    @ExceptionHandler(Exception.class)//此方法捕获Exception异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//状态码返回500
    public RestErrorResponse doException(Exception e){

        log.error("捕获异常：{}",e.getMessage());
        e.printStackTrace();

        return new RestErrorResponse(e.getMessage());
    }
}
