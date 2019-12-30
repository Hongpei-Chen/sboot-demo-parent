package org.chp.sboot.mq.support;

import lombok.extern.slf4j.Slf4j;
import org.chp.sboot.mq.common.LogMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author jeff
 * <p>Date: 2019-11-13 23:01:00</p>
 */
@Slf4j
@Component
@RabbitListener(queues = "logQueue")
public class Receiver {

    @RabbitHandler
    public void process(LogMessage logMessage){
        log.info("接受到的信息：{}", logMessage);
    }
}
