package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/16
 * @Copyright： 日拱一卒 功不唐捐！
 */
public class TestEasyExcel2 {
    public static void main(String[] args) {
        //实现excel写操作

        //1.设置写入的excel文件的路径和名称
        String filename = "C:\\Users\\Lei\\Desktop\\lyq01.xlsx";

        //2.调用easyexcel的方法实现读操作
        EasyExcel
                .read(
                        filename,
                        DemoData2.class,
                        new ExcelListener())
                .sheet()
                .doRead();
    }
}
