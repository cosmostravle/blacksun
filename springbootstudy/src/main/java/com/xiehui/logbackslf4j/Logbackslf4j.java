package com.xiehui.logbackslf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//手动创建Logger
@Service
public class Logbackslf4j {
    //手动创建Logger
    private static final Logger logger = LoggerFactory.getLogger(Logbackslf4j.class);

    public void  logInfo(){
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
}
