package com.coviam.service;

import com.coviam.Util.EmployeeRelationshipUtil;
import com.coviam.dao.EmployeeRepository;
import com.coviam.model.Employee;
import com.coviam.model.EmployeeUIModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private EmployeeRepositoryCustomImpl employeeRepositoryCustomIml;

    /**
     * return empty list if no employee found for given Id else do bfs traversal to get the list of Juniors.
     *
     * @param id Employee Id whoes juniors are needed to be found.
     * @return list of juniors
     */
    public List<EmployeeUIModel> getEmployeeList(String id) {
        //adds immediate juniors
        List<EmployeeUIModel> employeeUIModels = employeeRepository.findByManagerId(id)
                .stream()
                .map(EmployeeRelationshipUtil::toUIModel)
                .collect(Collectors.toList());

        Employee employee1 = Employee.builder()
                .id("id")
                .name("name")
                .build();

        //add other subordinates
        List<EmployeeUIModel> subordinates = employeeUIModels;
        while (!subordinates.isEmpty()) {
            subordinates = subordinates
                    .stream()
                    .map(employee -> employeeRepository.findByManagerId(employee.getId()))
                    .flatMap(List::stream)
                    .map(EmployeeRelationshipUtil::toUIModel)
                    .collect(Collectors.toList());

            employeeUIModels.addAll(subordinates);
        }

        // adds itself into the list
        employeeRepository.findById(id)
                .map(EmployeeRelationshipUtil::toUIModel)
                .ifPresent(employeeUIModels::add);

        return employeeUIModels;
    }

    public List<Employee> getQueryResult(){
        List<Employee> employeesList = new ArrayList<>();
        employeeRepositoryCustomIml.findAllUsingCursor()
                .forEachRemaining(employeesList::add);
        return employeesList;
    }

}
