package com.cloud.eduService.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author testjava
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduTeacher对象", description="讲师")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "teacher id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "teacher id")
    private String name;

    @ApiModelProperty(value = "Introduction of teacher")
    private String intro;

    @ApiModelProperty(value = "teacher qualification")
    private String career;

    @ApiModelProperty(value = "Title 1 Senior Lecturer 2 Chief Lecturer")
    private Integer level;

    @ApiModelProperty(value = "Teacher avatar")
    private String avatar;

    @ApiModelProperty(value = "sort")
    private Integer sort;

    @TableLogic
    @ApiModelProperty(value = "delete logic: 1（true）deleted， 0（false）not deleted")
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "create time")
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "update time")
    private Date gmtModified;


}
