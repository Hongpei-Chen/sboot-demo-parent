package org.chp.sboot.mongodb.domian;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jeff
 * <p>Date: 2019-11-11 16:50:00</p>
 */
public interface UserRepository extends MongoRepository<User, Integer> {
}
