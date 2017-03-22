package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


/**
 * Created by Aditya
 */

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findById(String id);
}
