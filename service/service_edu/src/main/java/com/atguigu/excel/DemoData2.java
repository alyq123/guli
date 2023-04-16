package com.atguigu.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.models.auth.In;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/16
 * @Copyright： 日拱一卒 功不唐捐！
 */
public class DemoData2{
    //设置excel第一列对应的属性
    @ExcelProperty(index = 0)
    private Integer sno;

    //设置excel第二列对应的属性
    @ExcelProperty(index = 1)
    private String sname;

}
