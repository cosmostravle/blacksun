package com;

import com.xiehui.logbackslf4j.Logbackslf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/*
*当启动类与测试类不在同一路径下，Autowired会报红，甚至启动报错：无法创建对应bean
* 解决方法：
* 1. 保证启动类和测试类同一路径
* 2. 注解@SpringBootTest，换成@SpringBootTest(classes =测试类名称.class )
*    同时添加扫描注解，扫描启动类和其它bean所在路径  @ComponentScan(basePackages = {"com.xiehui"})
*/

//@SpringBootTest  非同路径，爆红，增加classes =
@SpringBootTest(classes =SpringBootTestErrorDemo.class )
// 指定启动类包扫描范围,否则Autowired会爆红，且启动报找不到bean
@ComponentScan(basePackages = {"com.xiehui"})

public class SpringBootTestErrorDemo {
    @Autowired
    private Logbackslf4j Logbackslf4j;
    @Test
    public  void contextLoads() {
        Logbackslf4j.logInfo();
    }
}
