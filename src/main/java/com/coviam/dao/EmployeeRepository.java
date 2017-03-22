package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Created by Aditya
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findById(String id);
}
