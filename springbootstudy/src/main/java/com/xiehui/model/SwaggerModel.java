package com.xiehui.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Size;

@ApiModel("学生对象")
@Data
@ToString
public class SwaggerModel {
    @ApiModelProperty(value = "学生id",example = "123456")
    @Size(max = 18)
    private  long id;
    @ApiModelProperty(value = "Nome da lista", required = false,
            dataType="java.lang.String",
            allowableValues="range[-infinity, 100]")
    @ApiParam()
    private String name;

    private int gender;

    public SwaggerModel(long id, String name, int gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
