package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.repository.Repository;

import java.util.Optional;


/**
 * Created by Aditya
 */
@org.springframework.stereotype.Repository
public interface EmployeeRepository extends Repository<Employee,String> {
    Optional<Employee> findById(String id);
    Employee save(Employee entity);
}
