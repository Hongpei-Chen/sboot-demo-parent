package org.chp.sboot.mongodb;

import cn.hutool.crypto.digest.MD5;
import org.chp.sboot.mongodb.dao.UserDao;
import org.chp.sboot.mongodb.domian.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jeff
 * <p>Date: 2019-11-11 16:47:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootMongodbApplicationTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("陈东");
        user.setPassword(MD5.create().digestHex("asas12AW@34"));
        user.setPhone("18602029890");
        user.setEmail("18602029890@163.com");
        user.setAge(18);

        userDao.save(user);

    }

    @Test
    public void testFind(){
        User user = userDao.find(1);
        System.out.println(user);
    }

}
