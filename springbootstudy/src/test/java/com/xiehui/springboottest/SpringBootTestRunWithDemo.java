package com.xiehui.springboottest;

import com.xiehui.logbackslf4j.Logbackslf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/*
 *使用@Test是org.junit.Test时，必须结合@RunWith(SpringRunner.class)，
 * 否则自动注入报错：java.lang.NullPointerException: Cannot invoke 对应bean
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestRunWithDemo {

    @Autowired
    private Logbackslf4j Logbackslf4j;

    @Test
    public  void contextLoads() {
        Logbackslf4j.logInfo();
    }
}
