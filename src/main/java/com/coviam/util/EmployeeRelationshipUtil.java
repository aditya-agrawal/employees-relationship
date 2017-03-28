package com.coviam.util;

import com.coviam.model.Employee;
import com.coviam.model.EmployeeUIModel;

/**
 * Created by Aditya.
 */
public class EmployeeRelationshipUtil {


    public static EmployeeUIModel toUIModel(Employee employee) {
        return EmployeeUIModel.builder()
                .id(employee.getId())
                .name(employee.getName())
                .managerId(getManagerIdIfPresent(employee))
                .build();
    }

    private static String getManagerIdIfPresent(Employee employee) {
        Employee manager = employee.getManager();
        if (manager != null) {
            return manager.getId();
        } else {
            return null;
        }
    }
}
