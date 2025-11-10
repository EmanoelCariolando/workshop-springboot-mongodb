package com.workshop.workshopmongo.config;

import com.workshop.workshopmongo.domains.User;
import com.workshop.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User p1 = new User(null,"Manel","maneldocapa@gmail.com");
        User p2 = new User(null,"sofia","maximos@gmail.com");
        User p3 = new User(null,"toquin","tutuca@gmail.com");

        repository.saveAll(Arrays.asList(p1,p2,p3));
    }
}
