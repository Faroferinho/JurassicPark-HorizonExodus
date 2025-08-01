package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Authorization {
    private String user;
    private String token;

    public Authorization(String user, String token){
        this.user = user;
        this.token = token;
    }
}
