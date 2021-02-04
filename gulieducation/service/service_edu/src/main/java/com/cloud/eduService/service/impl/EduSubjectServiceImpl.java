package com.cloud.eduService.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.eduService.entity.EduSubject;
import com.cloud.eduService.entity.excel.SubjectData;
import com.cloud.eduService.entity.subject.OneSubject;
import com.cloud.eduService.entity.subject.TwoSubject;
import com.cloud.eduService.listener.SubjectExcelListener;
import com.cloud.eduService.mapper.EduSubjectMapper;
import com.cloud.eduService.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-01-31
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<OneSubject> getOneTwoSubject() {
        //get all rank 1 subject and all rank 2 subject
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id", 0);
        List<EduSubject> subjectListOne = this.list(wrapperOne);
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id", 0);
        List<EduSubject> subjectListTwo = this.list(wrapperTwo);
        //capsule rank 1 subject
        List<OneSubject> finalOneList = new ArrayList<>();
        for (EduSubject subject:
             subjectListOne) {
            OneSubject oneSub = new OneSubject();
            BeanUtils.copyProperties(subject, oneSub);
            List<TwoSubject> finalTwoList = new ArrayList<>();
            for (EduSubject sub2:
                 subjectListTwo) {
                if(sub2.getParentId().equals(subject.getId())){
                    TwoSubject twoSub = new TwoSubject();
                    BeanUtils.copyProperties(sub2, twoSub);
                    finalTwoList.add(twoSub);
                }
            }
            oneSub.setChildren(finalTwoList);
            finalOneList.add(oneSub);
        }
        return finalOneList;
    }
}
