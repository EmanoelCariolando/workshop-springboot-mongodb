package com.workshop.workshopmongo.service;

import com.workshop.workshopmongo.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workshop.workshopmongo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
