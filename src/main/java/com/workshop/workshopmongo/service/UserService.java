package com.workshop.workshopmongo.service;

import com.workshop.workshopmongo.domains.User;
import com.workshop.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workshop.workshopmongo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()){
            throw new RuntimeException();
        }
        return user.get();
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDto(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        User entity = repo.findById(obj.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        updateData(entity, obj);
        return repo.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        // ... e o que mais você quiser atualizar
    }
}
