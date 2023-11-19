package com.xiehui.springboottest;

import com.xiehui.logbackslf4j.Logbackslf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootTestDemo {

    @Autowired
    private Logbackslf4j Logbackslf4j;

    @Test
    public  void contextLoads() {
        Logbackslf4j.logInfo();
    }
}
