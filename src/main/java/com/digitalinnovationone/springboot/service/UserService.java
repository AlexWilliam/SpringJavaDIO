package com.digitalinnovationone.springboot.service;

import com.digitalinnovationone.springboot.model.User;
import com.digitalinnovationone.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user){
        String pass = user.getPassword();
        // criptografando a senha
        user.setPassword(passwordEncoder.encode(pass));
        userRepository.save(user);
    }

}
