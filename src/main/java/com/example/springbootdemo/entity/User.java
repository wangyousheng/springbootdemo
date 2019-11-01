package com.example.springbootdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: User.java, v 0.1 2019年08月07日 15:34 wb-wys567063 Exp $
 */
@Getter
@Setter
public class User {
    @NotNull(message = "name不能为空")
    private String name;
    @Min(value = 0,message = "age<0")
    @Max(value = 100,message = "age>0")
    private int age;
}
