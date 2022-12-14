package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class MQMessageProducerController {

    private final JmsTemplate jmsTemplate;

    @PutMapping("send")
    String sendFancyMessage(@RequestBody MQMessageModel model) {
        try {
            log.info("Send...");
            jmsTemplate.convertAndSend("DEV.QUEUE.1", model);
            return "OK";
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }
}
