package org.chp.sboot.cache;

import org.chp.sboot.cache.dao.UserDao;
import org.chp.sboot.cache.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jeff
 * <p>Date: 2019-11-12 22:11:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootCahceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFind(){
        User user1 = userDao.find(1);
        System.out.println("第一次查询：" + user1.getUsername());
        User user2 = userDao.find(1);
        System.out.println("第二次查询：" + user1.getUsername());
    }
}
