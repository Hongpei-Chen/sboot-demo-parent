package org.chp.sboot.mq.support;

import org.chp.sboot.mq.common.LogMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author jeff
 * <p>Date: 2019-11-13 22:55:00</p>
 */
@Component
public class Sender {

    private final AmqpTemplate amqpTemplate;

    public Sender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(LogMessage logMessage){
        amqpTemplate.convertAndSend("logQueue", logMessage);
    }
}
