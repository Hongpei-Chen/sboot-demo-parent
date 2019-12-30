package org.chp.sboot.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.chp.sboot.dubbo.facade.IMessageService;
import org.springframework.stereotype.Component;

/**
 * @author jeff
 * <p>Date: 2019-11-14 17:49:00</p>
 */
@Service(interfaceClass = IMessageService.class)     //暴露服务
@Component      //注册bean
public class MessageServiceImpl implements IMessageService {
    @Override
    public String sendMessage(String message) {
        return "sboot-dubbo-provider: " + message;
    }
}
