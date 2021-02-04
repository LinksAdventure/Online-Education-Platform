package com.cloud.eduService.controller;


import com.cloud.commonUtils.Msg;
import com.cloud.eduService.entity.EduSubject;
import com.cloud.eduService.entity.subject.OneSubject;
import com.cloud.eduService.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-01-31
 */
@RestController
@RequestMapping("/eduService/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    @PostMapping("/add")
    public Msg addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file, eduSubjectService);
        return Msg.success();
    }

    @GetMapping("/all")
    public Msg getAllSubject(){
        List<OneSubject> list = eduSubjectService.getOneTwoSubject();

        return Msg.success().data("list", list);
    }


}

