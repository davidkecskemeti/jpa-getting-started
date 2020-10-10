package com.dk.jpa.gettingstarted.repository;

import com.dk.jpa.gettingstarted.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    User findByEmail(String email);
}
