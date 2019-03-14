package com.lb.springboot.queue.simpleQueue;

import com.lb.springboot.util.MQDBUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/3/6
 * @ Description：
 * @ Modified By：
 */
public class MQ_Receiver {

    private static String QUEUE_NAME="test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = MQDBUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf-8");
                System.out.println("[Receiver]:"+msg);
            }
        };

        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

//        channel.close();
//
//        connection.close();
    }
}
