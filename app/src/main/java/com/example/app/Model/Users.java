package com.example.app.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@Data // Used to provide getters,setters, toString and required constructors
public class Users {
    //Entity representation of table users in java

    //fields
    @Id
    private String userId;
    private String name;
    private String email;
    private String password;

}
