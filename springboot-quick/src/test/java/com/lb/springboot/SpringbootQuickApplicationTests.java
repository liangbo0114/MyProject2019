package com.lb.springboot;

import com.lb.springboot.bean.Person;
import com.lb.springboot.bean.Person2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot 单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入的容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootQuickApplicationTests {

    @Autowired
    Person person;
    @Autowired
    Person2 person2;

    @Test
    public void contextLoads() {
        System.out.println(person);
        System.out.println("===============================");
        System.out.println(person2);

    }

}
