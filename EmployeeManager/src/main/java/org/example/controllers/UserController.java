package org.example.controllers;

import org.example.documents.User;
import org.example.documents.dto.UserDTO;
import org.example.safety.Constants;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(
        origins = "http://localhost:3000"
)
public class UserController implements CRUDController<User, UserDTO> {
    @Autowired
    private UserService service;

    @Override
    @PostMapping(Constants.USER)
    public ResponseEntity<User> create(@RequestBody UserDTO dto) {
        User newUser = service.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @Override
    @PutMapping(Constants.USER + "{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody UserDTO dto) {
        User updatedUser = new User(dto);

        updatedUser.setId(id);

        updatedUser = service.change(updatedUser);

        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @Override
    @GetMapping(Constants.USER)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping(Constants.USER + "{id}")
    public ResponseEntity<Optional<User>> findById(@RequestHeader String id) {
        return ResponseEntity.ok(service.findByID(id));
    }

    @Override
    @DeleteMapping(Constants.USER + "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteByID(id);

        return ResponseEntity.noContent().build();
    }
}
