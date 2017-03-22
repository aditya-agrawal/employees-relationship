package com.coviam.service;

import com.coviam.dao.EmployeeRepository;
import com.coviam.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Aditya.
 */
@Slf4j
@Service
public class EmployeeRelationshipService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * return empty list if no employee found for given Id else do bfs traversal to get the list of Juniors.
     *
     * @param id Employee Id whoes juniors are needed to be found.
     * @return list of juniors
     */
    public List<Employee> getEmployeeList(String id) {
        List<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty()) {
            log.warn("No employee with employee Id: {} found", id);
            return Collections.emptyList();
        } else {
            return employee;
        }
    }
}
