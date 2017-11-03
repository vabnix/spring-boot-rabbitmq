package com.vaibhav.rabbitmq.Domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.UUID;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class)
public class Message {

    private UUID messageId;
    private String messageBody;

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
