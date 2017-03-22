package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Aditya
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
    List<Employee> findById(String id);
}
