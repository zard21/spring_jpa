package com.zard21.jpa;

import com.zard21.jpa.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
public class JpaApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        userRepository.save(new User("001", "Kim", "1111"));
//        userRepository.save(new User("002", "Lee", "2222"));
//        userRepository.save(new User("003", "Park", "3333"));
//        setUser("Choi");
    }
}
