package com.example.app.DTO;

import lombok.*;


@Data
public class LoginRequest {
    private String name;
    private String email;
    private String password;
}
