package com.coviam.service;

import com.coviam.Util.EmployeeRelationshipUtil;
import com.coviam.dao.EmployeeRepository;
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
    @Autowired
    private EmployeeRepositoryCustomImpl employeeRepositoryCustomIml;

    /**
     * return empty list if no employee found for given Id else do bfs traversal to get the list of Juniors.
     *
     * @param id Employee Id whoes juniors are needed to be found.
     * @return list of juniors
     */
    public List<EmployeeUIModel> getEmployeeList(String id) {
        List<EmployeeUIModel> employeeUIModels = addImmediateJuniors(id);

        addNonImmediateJuniors(employeeUIModels);

        addItself(id, employeeUIModels);

        return employeeUIModels;
    }

    private void addItself(String id, List<EmployeeUIModel> employeeUIModels) {
        employeeRepository.findById(id)
                .map(EmployeeRelationshipUtil::toUIModel)
                .ifPresent(employeeUIModels::add);
    }

    private List<EmployeeUIModel> addImmediateJuniors(String id) {
        return employeeRepository.findByManagerId(id)
                    .stream()
                    .map(EmployeeRelationshipUtil::toUIModel)
                    .collect(Collectors.toList());
    }

    private void addNonImmediateJuniors(List<EmployeeUIModel> employeeUIModels) {
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
    }
}
