package org.example.services;

import org.example.documents.User;
import org.example.documents.dto.LoginDTO;
import org.example.documents.dto.UserDTO;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CRUDServices<User, UserDTO>{
    @Autowired
    UserRepository repository;


    @Override
    public User save(UserDTO dto) {
        return repository.save(new User(dto));
    }

    @Override
    public User change(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findByID(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByID(String id) {
        repository.deleteById(id);
    }

    public boolean verifyUser(LoginDTO dto){
        User u = repository.findFirstByEmail(dto.getEmail()).get();

        return u.getEmail().equals(dto.getEmail()) && u.getPassword().equals(dto.getPassword());
    }
}
