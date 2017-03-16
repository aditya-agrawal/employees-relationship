package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


/**
 * Created by Aditya
 */

@Component
public interface EmployeeDao extends CrudRepository<Employee, String> {
}
