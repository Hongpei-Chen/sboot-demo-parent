package org.chp.sboot.mybatis.dao;

import org.chp.sboot.mybatis.domain.User;
import org.chp.sboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeff
 * <p>Date: 2019-11-06 18:31:00</p>
 */
@Repository
public class UserDao {

    private final UserMapper userMapper;

    @Autowired
    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    public List<User> findAll(){
        return userMapper.selectList(null);
    }

    public User findById(Integer id){
        return userMapper.findById(id);
    }

    public void save(User user){
        userMapper.insert(user);
    }
}
