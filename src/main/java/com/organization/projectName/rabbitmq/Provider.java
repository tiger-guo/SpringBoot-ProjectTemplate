package com.organization.projectName.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-learn-shiyanlou
 * @description: RabbitMQ 发送
 * @author: liuguohu
 * @create: 2020-03-08 14:10
 **/

@Component
public class Provider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String msg) {
        System.out.println("提供者 发送消息：" + msg);
        amqpTemplate.convertAndSend("fanoutExchange", "", msg);
    }
}
