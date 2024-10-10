package com.example.app.Services;

import com.example.app.DTO.LoginRequest;
import com.example.app.DTO.RegistrationRequest;
import com.example.app.Model.Admin;
import com.example.app.Model.Assignment;
import com.example.app.Model.Users;
import com.example.app.UserRepository.AdminRepository;
import com.example.app.UserRepository.AssignmentRepository;
import com.example.app.UserRepository.UserRepository;

import org.springframework.stereotype.Service;


import java.util.List;

// These are the below service methods for endpoints

@Service
public class service {
    private AdminRepository adminRepository;
    private UserRepository userRepository;
    private AssignmentRepository assignmentRepository;
    public service(AdminRepository adminRepository,UserRepository userRepository, AssignmentRepository assignmentRepository){
        this.assignmentRepository=assignmentRepository;
        this.userRepository=userRepository;
        this.adminRepository=adminRepository;
    }

    //uploads assignments to Mongodb
    public Assignment uploadAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    //method for user login
    public String userLogin(LoginRequest loginRequest){
       if( userRepository.findByEmail(loginRequest.getEmail())
                .isEmpty()) {
           return "failed";
       } else {
           return "Success";
       }
    }

    //service method for admin login
    public String adminLogin(LoginRequest loginRequest){
        if(adminRepository.findByEmail(loginRequest.getEmail())
                .isEmpty()){
            return "failed";
        }else{
            return "Success";
        }
    }

    //method for user registration
    public Boolean userRegisterRequest(RegistrationRequest request) {
        // Check if the email is already registered
        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            // Create a new User
            Users user = new Users();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            userRepository.save(user);
            return true;
        }else{
            return false;
        }
    }

    //method for admin registration
    public Boolean adminRegisterRequest(RegistrationRequest request) {
        // Check if the email is already registered
        if (adminRepository.findByEmail(request.getEmail()).isEmpty()) {
            Admin admin = new Admin();
            admin.setAdmin(request.getName());
            admin.setEmail(request.getEmail());
            admin.setPassword(request.getPassword());
            adminRepository.save(admin);
            return true;
        }else {
            return false;
        }
        // Save the user in MongoDB

    }
    // fetches all the admins
    public List<Admin> fetchAllAdmins(){
        return adminRepository.findAll();
    }

    // fetches all the assignments
    public List<Assignment> fetchAllAssignments(){
        return assignmentRepository.findAll();
    }

    //accepts assignments
    public Assignment acceptAssignment(String id){
        Assignment assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus("Accepted");
        return assignmentRepository.save(assignment);
    }

    //rejects  assignments
    public Assignment rejectAssignment(String id){
        Assignment assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus("rejected");
        return assignmentRepository.save(assignment);
    }

}
