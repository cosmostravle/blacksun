package com.xiehui.logbak_slf4j;


import com.xiehui.logbackslf4j.Logbackslf4j;
import com.xiehui.logbackslf4j.Logbackslf4janno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class logbackslf4j1{

    @Autowired
    private Logbackslf4j logbackSlf4j ;

    @Autowired
    private Logbackslf4janno logbackslf4janno ;


    @Test
    public  void logbackSlf4jTest(){
        logbackSlf4j.logInfo();
        logbackslf4janno.logInfo();
    }

    @Test
    public  void logbackslf4jannoTest(){
        logbackslf4janno.logInfo();
    }
}
