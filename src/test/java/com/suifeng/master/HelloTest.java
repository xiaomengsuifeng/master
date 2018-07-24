package com.suifeng.master;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {
    @RequestMapping("/hello")
    public String test(){
        return "hello world";
    };
}
