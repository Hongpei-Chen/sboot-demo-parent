package org.chp.sboot.cache.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author jeff
 * <p>Date: 2019-11-06 15:24:00</p>
 */
@CacheConfig(cacheNames = "userCache")
public interface UserRepository extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User> {

    @Cacheable
    Optional<User> findById(Integer id);
}
