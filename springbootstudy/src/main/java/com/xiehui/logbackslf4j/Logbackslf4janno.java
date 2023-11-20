package com.xiehui.logbackslf4j;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//注解式使用log
@Slf4j
@Service
public class Logbackslf4janno {


    public void  logInfo(){
        log.debug("Debug  anno message");
        log.info("Info anno message");
        log.warn("Warning anno message");
        log.error("Error anno message");
    }
}
