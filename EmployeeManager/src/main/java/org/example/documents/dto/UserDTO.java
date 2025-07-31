package org.example.documents.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private int type;
}
