package com.example.app.UserRepository;

import com.example.app.Model.Admin;
import com.example.app.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//admin repository implementing mongodb repository to use save and other methods in service

@Repository
public interface AdminRepository extends MongoRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
