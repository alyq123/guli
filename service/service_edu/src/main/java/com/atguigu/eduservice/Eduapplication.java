package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @description: 启动类
 * @author: lyq
 * @date: 2023/3/30
 * @Copyright： 日拱一卒 功不唐捐！
 */
@SpringBootApplication
@ComponentScan(basePackages = ("com.atguigu"))
public class Eduapplication {

    public static void main(String[] args) {
        SpringApplication.run(Eduapplication.class,args);
    }
}
