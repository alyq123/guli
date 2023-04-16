package com.atguigu.oss.controller;

import com.atguigu.oss.service.OssService;
import com.atguli.commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: lyq
 * @date: 2023/4/15
 * @Copyright： 日拱一卒 功不唐捐！
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    @PostMapping
    public R uploadOssFile(MultipartFile file){ //MultipartFile file用来得到用户上传的文件
        //上传文件到oss,并得到文件的url
        String url =ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }
}
