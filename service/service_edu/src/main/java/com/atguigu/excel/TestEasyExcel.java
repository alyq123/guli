package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/16
 * @Copyright： 日拱一卒 功不唐捐！
 */
public class TestEasyExcel {
    public static void main(String[] args) {
        //实现excel读写操作

        //1.设置写入的excel文件的路径和名称
        String filename = "C:\\Users\\Lei\\Desktop\\lyq01.xlsx";

        //2.调用easyexcel的方法实现写操作
        EasyExcel
                .write(filename,DemoData.class)
                .sheet("学生列表")
                .doWrite(getData());
    }

    //创建静态方法返回list集合
    private static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("lucy"+i);
            list.add(data);
            //凡是有流都要关闭，这里自动关闭
        }
        return list;
    }
}
