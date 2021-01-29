package com.cloud.commonUtils;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Msg {
    private Boolean success;

    private Integer code;

    private String message;

    private  Map<String, Object> data = new HashMap<>();

    private Msg(){}

    public static Msg success(){
        Msg msg = new Msg();
        msg.setSuccess(true);
        msg.setCode(ResultCode.success.getValue());
        msg.setMessage("success");
        return msg;
    }

    public static Msg fail(){
        Msg msg = new Msg();
        msg.setSuccess(false);
        msg.setCode(ResultCode.error.getValue());
        msg.setMessage("error");
        return msg;
    }

    public Msg data(String s, Object object){
        this.data.put(s,object);
        return this;
    }

    public Msg code(Integer code){
        this.code = code;
        return this;
    }
    public Msg message(String message){
        this.message = message;
        return this;
    }
}
