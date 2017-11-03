package com.vaibhav.rabbitmq.Service;

import com.vaibhav.rabbitmq.Domain.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    public String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    public String routingkey;

    public void send(Message message) {
        rabbitTemplate.convertAndSend(exchange, routingkey, message);
        System.out.println("Send msg = " + message);

    }
}
