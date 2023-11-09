package com.xiehui.springbootstudy.enums;

import com.xiehui.enums.GradeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EnumsTest {


    @Test
    void enumTest1(){
        System.out.println("年级编号："+ GradeEnum.ONE.getCode()+"，年级描述："+GradeEnum.ONE.getDescription());

        Assertions.assertEquals(GradeEnum.FOUR.getCode(),4);

        String desc1 = GradeEnum.getDescByCodeStram(1);
        String desc999 = GradeEnum.getDescByCodeStram(999);
        System.out.println(desc1);

        GradeEnum gradeEnumByCode = GradeEnum.getGradeEnumByCode(1);
        System.out.println(desc999); // 满足预期

    }
}
