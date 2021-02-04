package com.cloud.eduService.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OneSubject {
    private String id;
    private String title;
    List<TwoSubject> children = new ArrayList<>();
}
