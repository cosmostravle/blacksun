//package com.xiehui.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.Profiles;
//import org.springframework.stereotype.Component;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
////spring2.65以下版本，使用Swagger2时，才需要这样配置，springboot升级到3.0后使用新配置类
//@Component
//@EnableSwagger2
////@EnableWebMvc  //解决Springfox3.0与2.6.0及以上版本的冲突的问题  不需要
////@EnableOpenApi  不需要
//public class SwaggerConfig {
//
//    //扫描所有 并分组1
//    @Bean
//    public Docket docket1(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
//    }
//
//    @Bean //配置docket以配置Swagger具体参数
//    public Docket docket(Environment environment) {
//        // 设置要显示swagger的环境
//        Profiles of = Profiles.of("dev", "test");
//        // 判断当前是否处于该环境
//        // 通过 enable() 接收此参数判断是否要显示
//        boolean b = environment.acceptsProfiles(of);
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("student")
//                .enable(b) //配置是否启用Swagger，如果是false，在浏览器将无法访问
//                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
//                .apis(RequestHandlerSelectors.basePackage("com.xiehui.controller"))
//                // 配置如何通过path过滤,即这里只扫描请求以/kuang开头的接口
//                .paths(PathSelectors.ant("/**"))
//                .build();
//    }
//    //配置文档信息
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Swagger学习",
//                "学习演示如何配置Swagger",
//                "v1.0",
//                "http://terms.service.url/组织链接", // 组织链接
//                new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱"), // 联系人信息
//                "Apach 2.0 许可", // 许可
//                "许可链接", // 许可连接
//                new ArrayList<>()// 扩展
//        );
//    }
//}
