package com.lb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/2/21
 * @ Description：
 * @ Modified By：
 */

/**
 * @SpringBootApplication来标注一个主程序类，说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWorldMainApp {

    public static void main(String[] args) {
        //启动Spring
        SpringApplication.run(HelloWorldMainApp.class,args);
    }
}
