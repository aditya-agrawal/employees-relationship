package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * Created by Aditya
 */

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findById(String id);
    List<Employee> findByName(String name);
}
