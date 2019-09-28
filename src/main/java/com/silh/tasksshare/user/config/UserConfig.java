package com.silh.tasksshare.user.config;

import com.silh.tasksshare.user.repository.UserRepository;
import com.silh.tasksshare.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
}
