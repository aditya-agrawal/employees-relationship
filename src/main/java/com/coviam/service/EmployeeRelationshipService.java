package com.coviam.service;

import com.coviam.dao.EmployeeRepository;
import com.coviam.model.Employee;
import com.coviam.model.EmployeeUIModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<EmployeeUIModel> getEmployeeList(String id) {
        //adds immediate juniors
        List<EmployeeUIModel> employeeUIModels = employeeRepository.findByManagerId(id)
                .stream()
                .map(this::toUIModel)
                .collect(Collectors.toList());

        //add other subordinates
        List<EmployeeUIModel> subordinates = employeeUIModels;
        while (!subordinates.isEmpty()) {
            subordinates = subordinates
                    .stream()
                    .map(employee -> employeeRepository.findByManagerId(employee.getId()))
                    .flatMap(List::stream)
                    .map(this::toUIModel)
                    .collect(Collectors.toList());

            employeeUIModels.addAll(subordinates);
        }

        // adds itself into the list
        employeeRepository.findById(id)
                .map(this::toUIModel)
                .ifPresent(employeeUIModels::add);

        return employeeUIModels;
    }

    private EmployeeUIModel toUIModel(Employee employee) {
        return EmployeeUIModel.builder()
                .id(employee.getId())
                .name(employee.getName())
                .managerId(getManagerIdIfPresent(employee))
                .build();
    }

    private String getManagerIdIfPresent(Employee employee) {
        Employee manager = employee.getManager();
        if (manager != null) {
            return manager.getId();
        } else {
            return null;
        }
    }
}
