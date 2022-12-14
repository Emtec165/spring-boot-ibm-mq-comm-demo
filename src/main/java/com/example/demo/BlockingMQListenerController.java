package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class BlockingMQListenerController {

    private final JmsTemplate jmsTemplate;

    /**
     * Comment out this {@code AsyncMQListener} class to be able to properly use this method
     */
    @GetMapping("receive")
    MQMessageModel receive() {
        log.info("Receive...");
        // this JMS method is blocking I/O
        MQMessageModel response = (MQMessageModel) jmsTemplate.receiveAndConvert("DEV.QUEUE.1");
        log.info("" + response);
        return response;
    }
}
