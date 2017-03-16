package com.coviam.service;

import com.coviam.dao.EmployeeDao;
import com.coviam.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Aditya.
 */
@Slf4j
@Service
public class EmployeeRelationshipService {
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * return empty list if no employee found for given Id else do bfs traversal to get the list of Juniors.
     *
     * @param id Employee Id whoes juniors are needed to be found.
     * @return list of juniors
     */
    public List<Employee> getEmployeeList(String id) {

        Employee employee = employeeDao.findOne(id);

        if (employee == null) {
            log.warn("No employee with employee Id: {} found", id);
            return Collections.emptyList();
        } else {
            return bfsTraversal(employee);
        }
    }

    /**
     * BFS traversal for getting list of all the employee down in hierarchy.
     *
     * @param employee employee on the top of the hierarchy.
     * @return list of employees.
     */
    private List<Employee> bfsTraversal(Employee employee) {
        List<Employee> unvisitedEmployee = Collections.singletonList(employee);
        List<Employee> visitedEmployee = new LinkedList<>();

        while (!unvisitedEmployee.isEmpty()) {
            List<Employee> newVisitedEmployees = unvisitedEmployee.stream()
                    .map(Employee::getJuniorIds)
                    .flatMap(List::stream)
                    .map(immediateJuniors -> employeeDao.findOne(immediateJuniors))
                    .filter(visitedEmployee::contains)
                    .collect(Collectors.toList());

            visitedEmployee.addAll(newVisitedEmployees);
            unvisitedEmployee = newVisitedEmployees;
        }
        return visitedEmployee;
    }
}
