package org.chp.sboot.mq;

import org.chp.sboot.mq.common.LogMessage;
import org.chp.sboot.mq.support.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author jeff
 * <p>Date: 2019-11-13 23:06:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootMQTest {

    @Autowired
    private Sender sender;

    @Test
    public void testMq(){
        LogMessage message = new LogMessage();
        message.setId("log");
        message.setTitle("日志消息");
        message.setContent("测试mq日志内容");
        message.setCreateDate(new Date());

        sender.send(message);
    }
}
