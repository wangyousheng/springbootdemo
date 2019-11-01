package com.example.springbootdemo;

import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: TestController.java, v 0.1 2019年08月07日 15:30 wb-wys567063 Exp $
 */
@Controller
public class TestController {
    @Value("${app.environment}")
    private String env;

    @RequestMapping(value = {"","/","index"},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String index(){
        System.out.println("hello");
        return env+" hello!";
    }

    @PostMapping(value = "testuser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public String testuser(@RequestBody @Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        System.out.println(user);
        return "ok";
    }
}
