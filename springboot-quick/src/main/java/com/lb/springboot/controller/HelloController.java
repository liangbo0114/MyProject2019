package com.lb.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResponseBody 写在类的上面，表示这个类的所有方法返回的数据直接写给浏览器（如果是对象，转为json数据）
 * 可以用@RestController，代替@ResponseBody @Controller
 */
//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World !!!";
    }
}
