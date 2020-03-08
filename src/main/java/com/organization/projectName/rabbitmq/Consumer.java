package com.organization.projectName.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-learn-shiyanlou
 * @description:RabbitMQ 接受
 * @author: liuguohu
 * @create: 2020-03-08 14:15
 **/

@Component
public class Consumer {

    @RabbitListener(queues = "queueA")
    public void receiveQueueA(String msg){
        System.out.println("消费者 queueA 收到消息：" + msg);
    }

    @RabbitListener(queues = "queueB")
    public void receiveQueueB(String msg){
        System.out.println("消费者 queueB 收到消息：" + msg);
    }
}
