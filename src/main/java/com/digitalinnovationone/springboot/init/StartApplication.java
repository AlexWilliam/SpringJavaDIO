package com.digitalinnovationone.springboot.init;

import com.digitalinnovationone.springboot.model.User;
import com.digitalinnovationone.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("admin");
        if(user==null){
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGERS");
            userRepository.save(user);
        }
        user = userRepository.findByUsername("user");
        if(user ==null){
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            userRepository.save(user);
        }
    }
}
