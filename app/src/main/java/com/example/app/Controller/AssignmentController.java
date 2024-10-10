package com.example.app.Controller;

import com.example.app.DTO.LoginRequest;
import com.example.app.DTO.RegistrationRequest;
import com.example.app.Model.Admin;
import com.example.app.Model.Assignment;
import com.example.app.Model.Users;
import com.example.app.Services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {

    private service service1;

    //@Autowired
    public AssignmentController(service service1){
        this.service1=service1;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAssignment(@RequestBody Assignment assignment){
        service1.uploadAssignment(assignment);
        return ResponseEntity.status(HttpStatus.CREATED).body("Uploaded");
    }


    @PostMapping("/login/user")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequest loginRequest){
        String auth=service1.userLogin(loginRequest);
        if(auth=="Success"){ return ResponseEntity.ok("User Login Successfully"); }
        else{
            return ResponseEntity.ok("User not found");
        }
    }

    @PostMapping("/register/user")
    public ResponseEntity<String> userRegisterRequest(@RequestBody RegistrationRequest registrationRequest){
        if(service1.userRegisterRequest(registrationRequest)){
            return ResponseEntity.ok("User registered successfully");
        }else{
            return ResponseEntity.ok("User already registered");
        }
    }

    @PostMapping("/login/admin")
    public ResponseEntity<String> adminLogin(@RequestBody LoginRequest loginRequest){
        String auth = service1.userLogin(loginRequest);
        if(auth=="Success"){
            return ResponseEntity.ok("Admin login successfully");
        }else{
            return ResponseEntity.ok().body("Admin login unsuccessfully");
        }
    }

    @PostMapping("/register/admin")
    public ResponseEntity<String> adminRegisterRequest(@RequestBody RegistrationRequest registrationRequest){
        if(service1.adminRegisterRequest(registrationRequest)){
            return ResponseEntity.ok().body("Admin Registered successfully");
        }else{
            return ResponseEntity.ok("Admin already registered");
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> fetchAllAdmins(){
        List<Admin> admins=service1.fetchAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> fetchAllAssignments(){
        List<Assignment> assignments = service1.fetchAllAssignments();
        return ResponseEntity.ok(assignments);
    }

    @PostMapping("/assignments/{id}/accept")
    public ResponseEntity<String> acceptAssignment(@PathVariable String id){
        Assignment updateAssignment = service1.acceptAssignment(id);
        return ResponseEntity.ok("Accepted");
    }

    @PostMapping("/assignments/{id}/reject")
    public ResponseEntity<String> rejectAssignment(@PathVariable  String id){
        Assignment updatedassignment = service1.rejectAssignment(id);
        return ResponseEntity.ok("Rejected");
    }
}
