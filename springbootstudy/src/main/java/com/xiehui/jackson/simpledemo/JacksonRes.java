package com.xiehui.jackson.simpledemo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class JacksonRes {
    private  String  resCode;
    private  String  resMsg;
    private  String  resData;
    private  JacksonReq  res_req;
    private Map<String, String> additionalProperties = new ConcurrentHashMap<>();

    @JsonAnySetter
    public void setAdditionalProperties(String key,String v) {
        this.additionalProperties.put(key,v);
    }

    @JsonAnyGetter
    //如果没有@JsonAnyGetter json输出结果不是在根路径，而是在additionalProperties 如是下面的
    /*        "additionalProperties": {
            "attr2": "11",
            "attr1": "11"
           }
    */
    //而不是
    /*  {
            {},
            "attr2": "11",
            "attr1": "11"
       }
   */
    public Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }


}
