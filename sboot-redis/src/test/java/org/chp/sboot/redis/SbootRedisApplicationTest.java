package org.chp.sboot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jeff
 * <p>Date: 2019-11-07 16:00:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSet(){
        redisTemplate.opsForValue().set("test", "hello redis");
    }
}
