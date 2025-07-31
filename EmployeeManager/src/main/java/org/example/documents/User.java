package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.example.documents.dto.UserDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @Setter
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private int type;

    public User(){

    }

    public User(String id, String name, String email, String password, int type){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User(UserDTO dto){
        name = dto.getName();
        email = dto.getEmail();
        password = dto.getPassword();
        type = dto.getType();
    }
}
