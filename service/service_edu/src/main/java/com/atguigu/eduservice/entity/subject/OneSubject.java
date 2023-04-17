package com.atguigu.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/17
 * @Copyright： 日拱一卒 功不唐捐！
 */
@Data
//一级分类
public class OneSubject {
    private String id;
    private String title;

    //一个一级分类有n个二级分类,n=1,2,3...
    private List<TwoSubject> children = new ArrayList<>();
}
