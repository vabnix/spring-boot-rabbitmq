package com.vaibhav.rabbitmq.Controllers;

import com.vaibhav.rabbitmq.Domain.Message;
import com.vaibhav.rabbitmq.Service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1-rabbitmq")
public class RabbitMQController {

    private SenderService senderService;

    @Autowired
    public RabbitMQController(SenderService senderService) {
        this.senderService = senderService;
    }

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("messageBody") String messageBody) {
        try {
            Message message = new Message();
            message.setMessageId(UUID.randomUUID());
            message.setMessageBody(messageBody);
            senderService.send(message);
            return "Message sent to the RabbitMQ - Successful";
        } catch (Exception ex) {
            return "Message sent to the RabbitMQ - Unsuccessful";
        }
    }
}
