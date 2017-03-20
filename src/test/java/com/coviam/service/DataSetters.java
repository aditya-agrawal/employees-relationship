package com.coviam.service;

import com.coviam.model.Employee;

/**
 * Sets data for all the tests.
 */
public class DataSetters {
    private DataSetters(){

    }

    public static Employee getEmployee6() {
        return Employee.builder()
                .id("6")
                .name("Employee6")
                .juniorId("12")
                .juniorId("13")
                .build();
    }

    public static Employee getEmployee5() {
        return Employee.builder()
                .id("5")
                .name("employee5")
                .juniorId("11")
                .build();
    }

    public static Employee getEmployee4() {
        return Employee.builder()
                .id("4")
                .name("employee4")
                .juniorId("9")
                .juniorId("10")
                .build();
    }

    public static Employee getEmployee3() {
        return Employee.builder()
                .id("3")
                .name("employee3")
                .juniorId("6")
                .juniorId("7")
                .juniorId("8")
                .build();
    }

    public static Employee getEmployee2() {
        return Employee.builder()
                .id("2")
                .name("employee2")
                .juniorId("3")
                .juniorId("4")
                .juniorId("5")
                .build();
    }

    public static Employee getEmployee1() {
        return Employee.builder()
                .id("1")
                .name("employee1")
                .juniorId("2")
                .build();
    }
}
