package com.coviam.controller;

import com.coviam.dao.EmployeeRepository;
import com.coviam.model.Employee;
import com.coviam.service.EmployeeRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Aditya.
 */
@Slf4j
@Controller
@RequestMapping(value = "employee")
public class EmployeeRelationshipController {
    @Autowired
    private EmployeeRelationshipService employeeRelationshipService;
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * @param id employee Id
     * @return the list of all the employees lower in the hierarchy.
     */
    @RequestMapping(value = "junior", method = RequestMethod.GET)
    public ResponseEntity<?> juniors(@RequestParam String id) {
        log.info("User requested to get employee list for employee Id: {}", id);
        List<Employee> employeeList = employeeRelationshipService.getEmployeeList(id);
        return ResponseEntity.ok(employeeList);
    }

    /**
     * registers the employee.
     * @param employeeDetails employee details
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employeeDetails) {
        log.info("Employee with id: {} is registered", employeeDetails.getId());
        employeeRepository.save(employeeDetails);
        return ResponseEntity.ok().build();
    }
}
