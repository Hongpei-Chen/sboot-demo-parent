package org.chp.sboot.mongodb.dao;

import org.chp.sboot.mongodb.domian.User;
import org.chp.sboot.mongodb.domian.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jeff
 * <p>Date: 2019-11-11 16:52:00</p>
 */
@Repository
public class UserDao {

    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User find(Integer id){
        return userRepository.findById(id).orElse(new User());
    }
}
