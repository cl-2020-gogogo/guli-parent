package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-01-20
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
@Api(description = "讲师管理")
public class EduTeacherController {

    @Resource
    EduTeacherService eduTeacherService;

    //查询讲师表全部数据
    @ApiOperation(value = "查询讲师表全部数据")
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<EduTeacher> list=  eduTeacherService.list(null);

        return R.ok().date("items",list);
    }
    //逻辑删除讲师
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id",value = "讲师ID",required = true) @PathVariable String id){
        Boolean flag=eduTeacherService.removeById(id);
        if(flag){
           return R.ok();
        }else{
            return R.error();
        }
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable Long current,@PathVariable Long limit){
        Page page=new Page(current,limit);
        eduTeacherService.page(page,null);
        Long total = page.getTotal();
        return R.ok();
    }

}

