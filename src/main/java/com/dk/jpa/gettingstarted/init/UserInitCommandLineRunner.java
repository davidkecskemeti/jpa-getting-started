package com.dk.jpa.gettingstarted.init;

import com.dk.jpa.gettingstarted.entity.User;
import com.dk.jpa.gettingstarted.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserInitCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // create users
        userRepository.save(new User("John Doe", "john.doe@example.com"));
        userRepository.save(new User("Emma Watson", "emma.watson@example.com"));
        userRepository.save(new User("Seno Reta", "seno.reta@example.com"));
        userRepository.save(new User("Mike Hassan", "mike.hassan@example.com"));

        // fetch all users
        log.info("Users found with findAll():");
        log.info("---------------------------");
        for (User user : userRepository.findAll()) {
            log.info(user.toString());
        }
        log.info("");

        // fetch user by id
        User user = userRepository.findById(1L).get();
        log.info("User found with findById(1L):");
        log.info("-----------------------------");
        log.info(user.toString());
        log.info("");

        // fetch user by email address
        User userWithEmail = userRepository.findByEmail("john.doe@example.com");
        log.info("User found with findByEmail('john.doe@example.com'):");
        log.info("----------------------------------------------------");
        log.info(userWithEmail.toString());
        log.info("");

        // delete all users
        userRepository.deleteAll();

        // confirm users deletion
        log.info("Total users after deletion with :");
        log.info("--------------------------");
        log.info(userRepository.count() + " users are in DB");
        log.info("");
    }
}
