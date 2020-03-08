package com.organization.projectName.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-learn-shiyanlou
 * @description:
 * @author: liuguohu
 * @create: 2020-03-08 14:08
 **/

@Component
public class RabbitConfig {
    @Bean
    public Queue queueA() {
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB() {
        return new Queue("queueB");
    }

    /**
     * 建立一个fanout模式的Exchange
     *
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 绑定队列A到交换机
     *
     * @param queueA
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingQueueA(Queue queueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    /**
     * 绑定队列A到交换机
     *
     * @param queueB
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingQueueB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }
}
