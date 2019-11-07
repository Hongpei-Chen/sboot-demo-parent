package org.chp.sboot.mybatis;

import cn.hutool.crypto.digest.MD5;
import org.chp.sboot.mybatis.dao.UserDao;
import org.chp.sboot.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author jeff
 * <p>Date: 2019-11-06 18:33:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void testFindList(){
        List<User> users = userDao.findAll();

        System.out.println(users);
        System.out.println(users.size());
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("陈晨");
        user.setPassword(MD5.create().digestHex("asas12AW@34"));
        user.setAge(22);
        user.setEmail("cchen@ky.com");
        user.setPhone("18620223102");
        user.setCreateDate(new Date());

        userDao.save(user);
    }

    @Test
    public void testFindById(){
        User user = userDao.findById(1);
        System.out.println(user);
    }

}
