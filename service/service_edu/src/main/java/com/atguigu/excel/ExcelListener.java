package com.atguigu.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/16
 * @Copyright： 日拱一卒 功不唐捐！
 */
public class ExcelListener extends AnalysisEventListener<DemoData2> {

    //一行一行读取excel内容(从第二行开始读取,第一行是表头,该方法不会读取第一行)
    @Override
    public void invoke(DemoData2 data, AnalysisContext analysisContext) {
        System.out.println("*****"+ data);
    }

    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer,String> headMap, AnalysisContext context){
        System.out.println("表头：" + headMap);
    }

    //读取完成之后执行这个方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
