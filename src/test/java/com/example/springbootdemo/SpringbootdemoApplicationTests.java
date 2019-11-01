package com.example.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    protected             MockMvc               mockMvc;

    @Before
    public void contextLoads() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test public void index() throws Exception {
        mockMvc.perform(get("/index")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("dev开发wys hello!")).andReturn();
    }

    @Test public void testuser() throws Exception {
        User user = new User();
        mockMvc.perform(post("/testuser").contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("name不能为空")).andReturn();

        user.setName("test");
        user.setAge(-1);
        mockMvc.perform(post("/testuser").contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("age<0")).andReturn();

        user.setAge(12);
        mockMvc.perform(post("/testuser").contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("ok")).andReturn();
    }
}
