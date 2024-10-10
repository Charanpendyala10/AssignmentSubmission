package com.example.app.DTO;

import lombok.*;

@Data
public class RegistrationRequest {
    private String name;
    private String email;
    private String password;

}
