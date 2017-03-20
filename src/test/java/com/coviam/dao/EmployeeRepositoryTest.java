package com.coviam.dao;


import com.coviam.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.coviam.service.DataSetters.*;

/**
 * Created by Aditya.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @Before
    public void setUp() {

        repository.deleteAll();

        employee1 = repository.save(getEmployee1());
        employee2 = repository.save(getEmployee2());
        employee3 = repository.save(getEmployee3());
    }

    @Test
    public void setsIdOnSave() {

        Employee employee = repository.save(employee1);
        Assertions.assertThat(employee.getId()).isNotNull();
    }
}