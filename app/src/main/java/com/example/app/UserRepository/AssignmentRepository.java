package com.example.app.UserRepository;

import com.example.app.Model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//assignment repository implementing mongodb repository to use save and other methods in service

@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String> {

}
