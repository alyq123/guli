package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2023-04-16
 */
public interface EduSubjectService extends IService<EduSubject> {
    //1.添加课程分类
    void savaSubject(MultipartFile file,EduSubjectService subjectService);

    //2.课程分类列表(树形)
    List<OneSubject> getAllOneTwoSubject();
}
