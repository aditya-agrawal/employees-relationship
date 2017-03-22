package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


/**
 * Created by Aditya
 */

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findById(String id);
}
