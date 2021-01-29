package com.cloud.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.commonUtils.Msg;
import com.cloud.eduService.entity.EduTeacher;
import com.cloud.eduService.entity.vo.TeacherQuery;
import com.cloud.eduService.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-07
 */
@Api("teacher management")
@RestController
@RequestMapping("/eduService/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("find all teacher")
    @GetMapping("/all")
    public Msg findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        Msg msg = Msg.success().data("list", list);
        return msg;
    }

    @ApiOperation("delete teacher by id")
    @DeleteMapping("/{id}")
    public Msg deleteById(@PathVariable("id") String id){
        boolean b = eduTeacherService.removeById(id);
        return b ? Msg.success() : Msg.fail();
    }

    @GetMapping("pageAll/{current}/{size}")
    public Msg pageListTeacher(@PathVariable("current") long current, @PathVariable("size") long size){
        Page<EduTeacher> page= new Page<>(current, size);
        System.out.println(current);
        System.out.println(size);
        eduTeacherService.page(page);
        List<EduTeacher> records = page.getRecords();
        Long total = page.getTotal();
        Msg msg = Msg.success().data("total", total).data("rows", records);
        System.out.println(msg);
        return msg;
    }
    @PostMapping("pageCondition/{current}/{size}")
    public Msg pageTeacherCond(@PathVariable("current") long current, @PathVariable("size") long size,
                              @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> page = new Page<>(current, size);
        QueryWrapper<EduTeacher> queryWrapper =new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        queryWrapper.like(!StringUtils.isEmpty(name), "name", name);
        queryWrapper.eq(!StringUtils.isEmpty(level),"level", level);
        queryWrapper.ge(!StringUtils.isEmpty(begin), "gmt_create", begin);
        queryWrapper.le(!StringUtils.isEmpty(end), "gmt_create", end);
        queryWrapper.orderByDesc("gmt_create");
        eduTeacherService.page(page, queryWrapper);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return Msg.success().data("total", total).data("rows", records);
    }

    @PostMapping("")
    public Msg insert(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        return save ? Msg.success() : Msg.fail();
    }

    @GetMapping("/{id}")
    public Msg selectById(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return StringUtils.isEmpty(eduTeacher) ? Msg.fail() : Msg.success().data("teacher", eduTeacher);
    }

    @PutMapping("/{id}")
    public Msg updateById(@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        return b ? Msg.success() : Msg.fail();
    }
}

