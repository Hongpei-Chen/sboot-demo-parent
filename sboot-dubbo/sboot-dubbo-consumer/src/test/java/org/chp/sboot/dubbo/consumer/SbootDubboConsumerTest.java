package org.chp.sboot.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.chp.sboot.dubbo.facade.IMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jeff
 * <p>Date: 2019-11-14 18:17:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootDubboConsumerTest {

    //直连方式服务注入
//    @Reference(url = "dubbo://127.0.0.1:20880")
//    private IMessageService messageService;

    @Reference
    private IMessageService messageService;

    @Test
    public void testMessage(){
        System.out.println(messageService.sendMessage("hello dubbo"));
    }
}
