package com.atguigu.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 自定义异常
 * @author: lyq
 * @date: 2023/4/4
 * @Copyright： 日拱一卒 功不唐捐！
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuliException extends  RuntimeException{
    private Integer code;
    private String msg;

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
