//package com.xiehui.controller;
//
//import com.xiehui.model.SwaggerModel;
//import io.swagger.annotations.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Api("学生接口")
//@RestController
//public class SwaggerController20 {
//
//
//    @ApiOperation("查询单个SwaggerModel")
//    @GetMapping("/id")
//    public SwaggerModel select(@ApiParam("SwaggerModel对象") SwaggerModel swaggerModel){
//        SwaggerModel student = new SwaggerModel(1L, "小米", 1);
//        student.setName("小航");
//        System.out.println(student);
//        return student;
//    }
//    @ApiOperation("查询学SwaggerModel")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "查询成功", response = SwaggerModel.class),
//            @ApiResponse(code = 400, message = "请求参数有误"),
//            @ApiResponse(code = 401, message = "未授权访问"),
//            @ApiResponse(code = 500, message = "服务器内部错误")
//    })
////    @RequestMapping(value = "/hhh",name = "{id}") //会生成get post del update 四个swagger
//    @PostMapping(value = "/hhh",name = "{id}") //会生成get post del put 四个swagger
//    public SwaggerModel selectone(SwaggerModel swaggerModel){
//        SwaggerModel student = new SwaggerModel(1L, "小米", 1);
//        student.setName("小航");
//        System.out.println(student);
//        return student;
//    }
//
//}
