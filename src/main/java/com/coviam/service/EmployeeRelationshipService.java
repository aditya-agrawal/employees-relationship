package com.coviam.service;

import com.coviam.dao.EmployeeRepository;
import com.coviam.model.Employee;
import com.coviam.model.EmployeeUIModel;
import com.coviam.util.EmployeeRelationshipUtil;
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
    private Sender sender;
    @Autowired
    private Receiver receiver;

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

    public void saveDetails(Employee employeeDetails) {
        sender.sendMessage("employee.t", employeeDetails.toString());
        employeeRepository.save(employeeDetails);
    }

}
