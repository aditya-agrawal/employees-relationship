package com.coviam.service;

import com.coviam.dao.EmployeeRepository;
import com.coviam.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Optional<Employee> employee = employeeRepository.findById(id);

        if (!employee.isPresent()) {
            log.warn("No employee with employee Id: {} found", id);
            return Collections.emptyList();
        } else {
            return bfsTraversal(employee.get());
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
        visitedEmployee.add(0, employee);

        return visitedEmployee;
    }

    /**
     * gets the list of junior employees.
     * @param employee employee for which juniors needs to be found.
     * @return list of immediate juniors.
     */
    private List<Employee> getJuniorEmployeeList(Employee employee) {
        return employee.getJuniorIds()
                .stream()
                .flatMap(id -> streamopt(employeeRepository.findById(id)))
                .collect(Collectors.toList());
    }

    /**
     * Turns an Optional<T> into a Stream<T> of length zero or one depending upon
     * whether a value is present.
     */
    static <T> Stream<T> streamopt(Optional<T> opt) {
        return opt.map(Stream::of)
                .orElseGet(Stream::empty);
    }

}
