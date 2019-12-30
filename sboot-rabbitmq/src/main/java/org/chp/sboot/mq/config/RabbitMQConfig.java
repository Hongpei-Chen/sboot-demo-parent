package org.chp.sboot.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author jeff
 * <p>Date: 2019-11-13 23:04:00</p>
 */
@Configuration
public class RabbitMQConfig {


    @Bean
    public Queue logQueue(){
        return new Queue("logQueue");
    }
}
