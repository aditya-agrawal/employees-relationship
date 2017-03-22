package com.coviam.service;

import com.coviam.dao.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    /**
     * return empty list if no employee found for given Id else do bfs traversal to get the list of Juniors.
     *
     * @param id Employee Id whoes juniors are needed to be found.
     * @return list of juniors
     */
    public List<Employee> getEmployeeList(String id) {
        Employee employee = employeeRepository.findById(id);

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
            List<Employee> newVisitedEmployees = unvisitedEmployee
                    .stream()
                    .map(this::getJuniorEmployeeList)
                    .flatMap(List::stream)
                    .filter((o) -> !visitedEmployee.contains(o))
                    .collect(Collectors.toList());

            visitedEmployee.addAll(newVisitedEmployees);
            unvisitedEmployee = newVisitedEmployees;
        }

        //add itself to the start of the list.
        visitedEmployee.add(0,employee);

        return visitedEmployee;
    }

    private List<Employee> getJuniorEmployeeList(Employee employee1) {
        if (employee1 == null){
            return Collections.emptyList();
        }

        return employee1.getJuniorIds()
                .stream()
                .map(id -> employeeRepository.findById(id))
                .collect(Collectors.toList());
    }
}
