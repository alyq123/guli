package com.atguigu.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/16
 * @Copyright： 日拱一卒 功不唐捐！
 */
@Data
public class DemoData {
    //设置excel表头名称
    @ExcelProperty("学生编号")
    private Integer sno;

    @ExcelProperty("学生姓名")
    private String sname;
}
