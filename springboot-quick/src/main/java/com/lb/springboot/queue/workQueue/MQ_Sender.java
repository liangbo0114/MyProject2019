package com.lb.springboot.queue.workQueue;

import com.lb.springboot.util.MQDBUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/3/7
 * @ Description：
 * @ Modified By：
 */
public class MQ_Sender {

    private static String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = MQDBUtil.getConnection();
        //获取channel
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //每次只发一个
        channel.basicQos(1);
        for (int i = 0; i < 10; i++) {
            String msg = "Hello World ! ！！" + i;

            System.out.println("[WorkQueue_Sender]:" + msg);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

            Thread.sleep(1*20);
        }
        channel.close();

        connection.close();
    }
}
