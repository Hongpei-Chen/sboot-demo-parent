package org.chp.sboot.cache.dao;

import org.chp.sboot.cache.domain.User;
import org.chp.sboot.cache.domain.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jeff
 * <p>Date: 2019-11-12 22:09:00</p>
 */
@Repository
public class UserDao {

    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User find(Integer id){
        return userRepository.findById(id).orElse(new User());
    }
}
