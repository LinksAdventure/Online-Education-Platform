package com.cloud.eduService.controller;

import com.cloud.commonUtils.Msg;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduService/user")
@CrossOrigin
public class EduUserController {

    @PostMapping("/login")
    public Msg login(){
        return Msg.success().data("token", "admin");
    }

    @GetMapping("/info")
    public Msg info(){
        return Msg.success().data("name", "admin").data("avatar", "https://coderlink.oss-us-west-1.aliyuncs.com/Sinon.jpg");
    }
}
