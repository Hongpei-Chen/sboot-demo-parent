package org.chp.sboot.jpa.dao;

import org.chp.sboot.jpa.domain.User;
import org.chp.sboot.jpa.domain.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

/**
 * @author jeff
 * <p>Date: 2019-11-06 15:24:00</p>
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

    public Page<User> findPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");

        return userRepository.findAll(pageable);
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
