package com.atguigu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/16
 * @Copyright： 日拱一卒 功不唐捐！
 */
@Data
public class SubjectData {
    //设置excel第一列对应的属性
    @ExcelProperty(index = 0)
    private String oneSubjectName;

    //设置excel第二列对应的属性
    @ExcelProperty(index = 1)
    private String twoSubjectName;

}
