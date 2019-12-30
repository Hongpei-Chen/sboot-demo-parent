package org.chp.sboot.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jeff
 * <p>Date: 2019-11-13 17:33:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootMailTest {

    @Autowired
    private JavaMailSender javaMailSender;


    @Test
    public void testSendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1939150405@qq.com");
        message.setTo("13751333101@163.com");
        message.setSubject("主题：简单邮件测试");
        message.setText("测试简单邮件发送的内容");
        javaMailSender.send(message);
    }
}
