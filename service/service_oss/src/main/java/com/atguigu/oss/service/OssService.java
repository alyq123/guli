package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/15
 * @Copyright： 日拱一卒 功不唐捐！
 */public interface OssService {
    //上传头像到oss
    String uploadFileAvatar(MultipartFile file);
}
