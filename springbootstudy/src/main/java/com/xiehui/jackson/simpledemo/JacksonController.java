package com.xiehui.jackson.simpledemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;

@Controller("/simpledemo")
public class JacksonController {

    private static final Logger logger = LoggerFactory.getLogger(JacksonController.class);

    //ObejectMapper  序列化和反序列化，返回string
    /*
    *一开始没有加@ResponseBody 和 (@RequestBody 导致接收reqw为null，响应报404，
    * 因为接收和响应都是在响应体力的字符串，需要这俩注解
    */
    @PostMapping("/jsonByOMAnswerStr")
    /*
    * 注解是Spring框架中用于指示方法返回的对象应该被转换为指定的媒体类型如JSON、XML等）
    * 并作为HTTP响应的主体发送给客户端，如果响应是是视图则不需要
    * */
    @ResponseBody
    public String jsonByOMAnswerStr(@RequestBody String req) throws IOException {
        //@RequestBody 将HTTP请求的请求体（Request Body）部分映射到Controller方法的参数上，如果是url拼接的参数，则用@RequestParam
        logger.info("读取json请求：{}", req);

        //om序列化
        ObjectMapper om = new ObjectMapper();
        JacksonReq jacksonReq = om.readValue(req, JacksonReq.class);
        logger.info("om序列化string-req: {}", jacksonReq);

        JacksonRes jacksonRes = new JacksonRes();
        jacksonRes.setResCode("000000");
        jacksonRes.setResMsg("Success");
        jacksonRes.setResData(jacksonReq.toString());
        jacksonRes.setRes_req(jacksonReq);
        logger.info("jacksonRes: {}", jacksonRes);

        //om反序列化
        String resJson = om.writeValueAsString(jacksonRes);

        logger.info("输出json响应：{}", resJson);
        return resJson;
    }

    //no  ObejectMapper, 纯注解方式  序列化和反序列化
    @PostMapping("/jsonByAnnotationsBased")
    @ResponseBody
    public JacksonRes jsonByJacksonAnno(@RequestBody  JacksonReq req) throws IOException {
        logger.info("读取json请求：{}", req);
        JacksonRes jacksonRes = new JacksonRes();
        jacksonRes.setResCode("000000");
        jacksonRes.setResMsg("Success");
        jacksonRes.setResData(req.toString());
        jacksonRes.setRes_req(req);
        jacksonRes.setAdditionalProperties("attr1","11");
        jacksonRes.setAdditionalProperties("attr2","11");
        logger.info("输出json响应：{}", jacksonRes);
        return jacksonRes;
    }
}
