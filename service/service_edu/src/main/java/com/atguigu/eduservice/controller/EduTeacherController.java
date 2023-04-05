package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionhandler.GlobalExceptionHandler;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguli.commonutils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-03-30
 */
@Api(tags="讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    //http://localhost:8001/swagger-ui.html  swagger入口
    //访问地址 http://localhost:8001/eduservice/edu-teacher/findAll
    @Autowired
    private EduTeacherService teacherService;

    //查询讲师表所有数据

    @ApiOperation(value="所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        try {
            int i = 10/0;
        } catch (Exception e) {
           throw new GuliException(20001,"执行GuliException");
        }
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }

    //删除
    @ApiOperation(value="逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher (@ApiParam(name = "id", value = "讲师ID", required = true)
                                   @PathVariable String id){
        boolean flag =  teacherService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("pageTacher/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        //创建page对象
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        //调用方法实现分页
        //调用方法时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        teacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();  //数据list集合
        long total = pageParam.getTotal(); //总记录数

//        Map map = new HashMap<>();
//        map.put(total,"total");
//        map.put(records,"records");
//        return R.ok().data(map);

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "讲师条件查询")
    @PostMapping("pageTacherCondition/{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> pageParam =  new Page<>(page,limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //多条件查询
        //类似mysql动态查询
        String name = teacherQuery.getName();
        String begin = teacherQuery.getBegin();
        Integer level = teacherQuery.getLevel();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)){
            //条件
            wrapper.like("name",name);
        }

        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.le("gmt_modified",end);
        }

        //调用方法实现条件分页
        teacherService.page(pageParam,wrapper);
        List<EduTeacher> records = pageParam.getRecords();  //数据list集合
        long total = pageParam.getTotal(); //总记录数
        return R.ok().data("total",total).data("rows",records);

    }

    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }
        else {
            return R.error();
        }
    }

    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher teacher = teacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

