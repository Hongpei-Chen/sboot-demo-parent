package org.chp.sboot.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jeff
 * <p>Date: 2019-11-06 15:24:00</p>
 */
public interface UserRepository extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User> {
    
}
