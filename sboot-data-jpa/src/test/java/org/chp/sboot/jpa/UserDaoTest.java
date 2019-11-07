package org.chp.sboot.jpa;

import cn.hutool.crypto.digest.MD5;
import org.chp.sboot.jpa.dao.UserDao;
import org.chp.sboot.jpa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author jeff
 * <p>Date: 2019-11-06 15:36:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("华晨琦");
        user.setPassword(MD5.create().digestHex("asasaqvd"));
        user.setAge(23);
        user.setEmail("huachen@ky.com");
        user.setPhone("18630323102");
        user.setCreateDate(new Date());

        userDao.save(user);
    }


    @Test
    public void testFindPage(){
        Page<User> page = userDao.findPage(0, 2);
        System.out.println(page);
    }
}
