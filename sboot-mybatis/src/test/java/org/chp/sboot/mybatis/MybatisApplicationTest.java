package org.chp.sboot.mybatis;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.chp.sboot.mybatis.dao.MenuDao;
import org.chp.sboot.mybatis.dao.UserDao;
import org.chp.sboot.mybatis.domain.Menu;
import org.chp.sboot.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
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

    @Autowired
    private MenuDao menuDao;

    @Test
    public void testFindList(){
//        User user = userDao.findByUsername("上水");
//        System.out.println(user);

//        IPage<User> userIPage = userDao.findAll(1, 2);
//        System.out.println(userIPage.getRecords().size());


//        userDao.updateUserName(1, "李龙");

        User user =new User();
        user.setPassword("123456");

        userDao.updateBatchUser(user, Arrays.asList(1, 2, 3, 4));
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

    @Test
    public void testFindMenus() {
        List<Menu> menuList = menuDao.findAll("系统", false);
        System.out.println("菜单：" + menuList.size());
        if (CollectionUtil.isNotEmpty(menuList)) {
            menuList.forEach(menu -> System.out.println(menu));
        }

    }



}
