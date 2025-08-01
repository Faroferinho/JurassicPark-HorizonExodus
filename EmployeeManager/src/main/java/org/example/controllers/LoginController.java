package org.example.controllers;

import org.example.documents.dto.LoginDTO;
import org.example.documents.dto.UserDTO;
import org.example.safety.Constants;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoginController {
    @Autowired
    private UserService service;

    @GetMapping(Constants.LOGIN)
    public ResponseEntity<Boolean> verifyLogin(@RequestBody LoginDTO dto){

        if(service.checkAuthentication(dto)) {
            return ResponseEntity.ok(Boolean.TRUE);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User and/or Password");
    }

    //TODO - Change method name to a more descriptive one
    @GetMapping(Constants.REGISTER)
    public ResponseEntity<Boolean> checkRegister(@RequestBody UserDTO dto){
        if(service.userRegistered(dto.getEmail())){
            service.save(dto);

            return ResponseEntity.ok(Boolean.TRUE);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User and/or Password");
    }
}
