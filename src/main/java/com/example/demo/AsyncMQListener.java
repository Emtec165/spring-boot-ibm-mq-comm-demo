package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Slf4j
@Component
class AsyncMQListener {

    /**
     * Comment out this method to be able to use {@code BlockingMQListenerController.receive()}
     */
    @JmsListener(destination = "DEV.QUEUE.1")
    void receiveMQMessages(Message message) throws JMSException {
        log.info("Async MQ listener...");
        log.info("" + message.getBody(MQMessageModel.class));
    }
}
