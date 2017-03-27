package com.coviam.dao;

import com.coviam.model.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Created by Aditya
 */
@org.springframework.stereotype.Repository
public interface EmployeeRepository extends Repository<Employee, String> {
    @Cacheable(value = "employeeDetails")
    Optional<Employee> findById(String id);

    @Cacheable(value = "managerDetails")
    List<Employee> findByManagerId(String managerId);

    @CacheEvict(value = "employeeDetails")
    List<Employee> save(Employee id);
}
