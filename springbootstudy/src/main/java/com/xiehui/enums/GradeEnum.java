package com.xiehui.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * 1. 枚举里的属性，可以视为枚举常量，如：ONE(1,"大一"),
 * 2. 枚举里的code，尽量用interge，能支持集合和泛型，可以接收null值，可以自定义其它操作。但存储和性能消耗比int大
 * 3. 枚举里属性尽量都使用final修饰
 * 4. 每个枚举类，本身实现了interface Enum 接口，可以调用公用方法values()获取该枚举类的常量数组：AEnum[] values = AEnum.values()
 * 5. getDescByCodeStram(): stream流遍历枚举常量数组，filter过滤器筛选ee.getCode().equals的枚举常量
*/
public enum GradeEnum {
    ONE(1,"大一"),
    TWO(2,"大二"),
    THREE(3,"大三"),
    FOUR(4,"大四"),
    //定义一个数值是大于int取值范围的值：999 然后调用getDescByCodeStram，看看里的equals是否会导比对不一致问题
    NEW(999,"大999"),
    ;

    /**
     * 编码
    */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;

    GradeEnum(Integer code, String description) {
        this.code = code;
        this.desc = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return desc;
    }

    /**
     * 描述：stream流遍历，根据数值code,获取枚举decs
     * @param i 入参数值code，用来匹配枚举里的code
     */
    public static String getDescByCodeStram(Integer i){
        GradeEnum[] values = GradeEnum.values();
        List<GradeEnum> collect = Arrays.stream(values).
                filter(e -> e.getCode().equals(i)).collect(Collectors.toList());
        if(collect.size()>0&&collect.size()==1){
            return collect.get(0).getDescription();
        }
        return  null;
    }

    public  static GradeEnum getGradeEnumByCode(int i){
        for (GradeEnum value : GradeEnum.values()) {
            if(Objects.equals(i,value.getCode())){
                return value;
            }
        }
        return null;
    }

    /**
     * for循环
     */
    public  static  String getDescByCodeFori(Integer i){
        GradeEnum[] values = GradeEnum.values();
        for (GradeEnum value : values) {
            if(value.getCode().equals(i)){
                return value.getDescription();
            }
        }
        return  null;
    }


}
