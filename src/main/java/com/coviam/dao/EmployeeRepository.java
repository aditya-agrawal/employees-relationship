package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Created by Aditya
 */

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findById(String id);
}
