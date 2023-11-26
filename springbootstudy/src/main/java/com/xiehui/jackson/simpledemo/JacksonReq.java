package com.xiehui.jackson.simpledemo;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
* 该案例，包含日期，浮点金额，枚举类，布尔，List<pojo> 嵌套
* */
@Data
@ToString
/*
* @JsonInclude  用于控制在对象序列化为JSON 时，来排除具有空/空/默认值的属性，
* 通常使用JsonInclude.Include.NON_DEFAULT，排除，null,空和不同类型的默认值。 通常用在类级
* */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties({"phone","describe"}) //是一个类级注释，标记 Jackson 序列化和反序列化 将忽略的属性或属性列表
public class JacksonReq {

    @JsonProperty("id")
    private  String id;
    @JsonProperty(value = "custname")  //指定序列化和反序列化时的属性
    private  String name;
    private  String psword;
    private  int sex;
    @JsonIgnore  //无论序列化、反序列化，都忽略该字段
    private  String birthday;
    private  String address;
    private  String phone;
    private  boolean beautiful;
    /*
    * 在序列化BigDecimal或Decimal字段时，有一些重要的注意事项：
    * 精度保留和避免浮点数问题：由于BigDecimal表示精确的十进制数，而不是近似的二进制浮点数，将其序列化为字符串可以避免与浮点数相关的舍入误差和精度问题。
    * 所以：
    * 1. BigDecimal 一般用@JsonFormat(shape = JsonFormat.Shape.STRING)修饰，避免精度丢失
    * 2. 定制序列化器： 如果需要更多控制，可以实现自定义的JsonSerializer。这允许你完全控制如何序列化BigDecimal字段，包括处理精度和舍入。
    * 3. 全局配置： 如果你想要对所有BigDecimal字段应用相同的序列化规则，可以使用Jackson的全局配置。这涉及到配置ObjectMapper，例如
    * */
    private BigDecimal amount;
    private String  cach;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /*
    * JsonFormat，默认是序列化为字符串
    * 也可以通过@JsonFormat(shape = JsonFormat.Shape.ARRAY) 或 @JsonFormat(shape = JsonFormat.Shape.STRING)指定
    * 如为数组，返回形式 {"myDate": [2023, 11, 26]}
    * */
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date lastUpdateTime;
    private  String lastOperation;
    private List<ListPojo> pojoList;
    //TODO 枚举类作为属性的序列化  或许用到@JsonValue  见官方案例
    private  String describe;

//    @JsonAnySetter
//    @JsonAnyGetter
    /* 在序列化和反序列化能灵活的注入键值对，通常实例有map，json有未定义属性的数据
     * 但会与@JsonInclude冲突，需要在set方法里限制非空字段，
     * 但会与@JsonIgnore冲突，需要使用@JsonIgnoreProperties忽略个别字段
     * 如: {"name":"My bean","attr2":"val2","attr1":"val1"}
    *  ExtendableBean bean = new ExtendableBean("My bean");  bean.add("attr1", "val1");  bean.add("attr2", "val2");
    * */
    private Map<String, String> additionalProperties = new ConcurrentHashMap<>();

    @JsonAnySetter
    public void setAdditionalProperties(String key,String v) {
        // 但会与@JsonInclude冲突，需要在set方法里限制非空字段，
        //  但会与@JsonIgnore冲突，需要使用@JsonIgnoreProperties忽略个别字段
        if(StringUtils.isNotEmpty(v)&&StringUtils.isNotBlank(v)){
            this.additionalProperties.put(key,v);
        }
    }

    @JsonAnyGetter
    public Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }

    //    {
//        "id":"id_083223ae36fd",
//            "name":"齐德龙东强",
//            "pswword":"123456",
//            "sex":0,
//            "birthday":"1993-01-01",
//            "address":"榕华大道",
//            "phone":"13956815301",
//            "beautiful":false,
//            "amount":12.01,
//            "cach":"601.01",
//            "createTime":"2023-11-21 23:51:51",
//            "lastUpdateTime":"2023-11-21 23:51:51",
//            "lastOperation":"学习",
//            "pojoList":[
//        {
//            "code":"code_52f4536cb2ad",
//                "msg":"msg_a8306978d386"
//        }
//  ],
//        "describe":"jackson类",
//         "attr2":"val2",
//         "attr1":"val1"
//    }

}
