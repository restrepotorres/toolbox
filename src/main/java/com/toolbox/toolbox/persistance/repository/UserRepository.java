package com.toolbox.toolbox.persistance.repository;

import com.toolbox.toolbox.persistance.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository  extends MongoRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

}
