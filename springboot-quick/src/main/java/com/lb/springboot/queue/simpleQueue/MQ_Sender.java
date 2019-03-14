package com.lb.springboot.queue.simpleQueue;

import com.lb.springboot.util.MQDBUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/3/6
 * @ Description：
 * @ Modified By：
 */
public class MQ_Sender {

    private static String QUEUE_NAME="test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = MQDBUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String msg = "Hello World ！";

        channel.basicPublish("",QUEUE_NAME,null, msg.getBytes());

        System.out.println("[Sender]:" + msg);

        channel.close();

        connection.close();
    }
}
