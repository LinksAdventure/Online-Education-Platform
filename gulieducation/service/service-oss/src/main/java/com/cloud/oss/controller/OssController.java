package com.cloud.oss.controller;

import com.cloud.commonUtils.Msg;
import com.cloud.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;
    @PostMapping
    public Msg uploadOssFile(MultipartFile file){
        String url = ossService.upLoadFileAvatar(file);
        return Msg.success().data("url", url);
    }
}
