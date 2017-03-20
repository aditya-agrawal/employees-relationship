package com.coviam.service;


import com.coviam.dao.EmployeeRepository;
import com.coviam.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.coviam.service.DataSetters.*;
import static org.mockito.Mockito.when;

/**
 * Created by Aditya.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeRelationshipServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeRelationshipService employeeRelationshipService;

    private Employee employee1 = getEmployee1();
    private Employee employee2 = getEmployee2();
    private Employee employee3 = getEmployee3();
    private Employee employee4 = getEmployee4();
    private Employee employee5 = getEmployee5();
    private Employee employee6 = getEmployee6();

    @Before
    public void setUp() {
        when(employeeRepository.findOne("id1")).thenReturn(employee1);
        when(employeeRepository.findOne("id2")).thenReturn(employee2);
        when(employeeRepository.findOne("id3")).thenReturn(employee3);
        when(employeeRepository.findOne("id4")).thenReturn(employee4);
        when(employeeRepository.findOne("id5")).thenReturn(employee5);
        when(employeeRepository.findOne("id6")).thenReturn(employee6);
    }

    @Test
    public void bfsTraversalTest() {
        List<Employee> actualList = employeeRelationshipService.getEmployeeList("id1");
        List<String> expectedList = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
        
    }

}