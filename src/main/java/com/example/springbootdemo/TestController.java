package com.example.springbootdemo;

import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

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

    @RequestMapping(value = {"","/","index"})
    @ResponseBody
    public String index(){
        System.out.println("hello");
        return env+" hello!";
    }

    @RequestMapping("testuser")
    @ResponseBody
    public String testuser(@Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        System.out.println(user);
        return "ok";
    }
    public static void main(String[] args) {
        int t = 0;
        String s = "Zhang Yan Yong";
        for (int i = 0; i < s.length(); i++) {
            t += Integer.valueOf(s.charAt(i));
        }
        System.out.println(t);
        String s1 = String.valueOf(t);
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(i));
            System.out.print(" ");
        }
    }
}
