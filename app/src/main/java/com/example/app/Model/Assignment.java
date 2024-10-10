package com.example.app.Model;


import lombok.Data;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Assignment {
    //Entity representation of table assignment in java

    //fields

    @Id
    private String user;
    private String admin;
    private String status;
    private String task;


}
