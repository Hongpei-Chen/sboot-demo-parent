package org.chp.sboot.mybatis.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    public IPage<User> findAll(int page, int size) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date");

        return userMapper.selectPage(new Page<>(page, size), queryWrapper);
    }

    public User findById(Integer id){
        return userMapper.findById(id);
    }

    public User findByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUsername, username));
    }

    public int updateUserName(Integer userId, String username) {

        User user = new User();
        user.setUsername(username);

        return userMapper.update(user, new QueryWrapper<User>().lambda().eq(User::getId, userId));
    }

    public int update(User user) {

        return userMapper.updateById(user);
    }

    public int updateBatchUser(User user, List<Integer> userIds) {
        return userMapper.update(user, new QueryWrapper<User>().lambda().in(User::getId, userIds));
    }

    public void save(User user){
        userMapper.insert(user);
    }
}
