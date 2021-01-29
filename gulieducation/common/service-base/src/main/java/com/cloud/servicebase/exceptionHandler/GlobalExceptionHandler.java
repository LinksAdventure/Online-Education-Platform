package com.cloud.servicebase.exceptionHandler;

import com.cloud.commonUtils.Msg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Msg error(Exception e){
        e.printStackTrace();
        return Msg.fail();
    }
}
