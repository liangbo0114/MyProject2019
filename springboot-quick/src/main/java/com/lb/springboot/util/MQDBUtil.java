package com.lb.springboot.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/3/6
 * @ Description：
 * @ Modified By：
 */
public class MQDBUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务器地址
        factory.setHost("127.0.0.1");
        //设置端口号
        factory.setPort(5672);
        //设置vhost
        factory.setVirtualHost("/center");
        //设置用户名
        factory.setUsername("lb");
        //设置密码
        factory.setPassword("lb");

        return factory.newConnection();
    }
}
