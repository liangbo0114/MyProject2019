package com.lb.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/2/21
 * @ Description：
 * @ Modified By：
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){

        return "HelloWorld!!!";
    }
}
