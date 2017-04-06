package com.coviam.Util;

import com.coviam.model.Employee;
import com.coviam.model.EmployeeUIModel;
import lombok.experimental.UtilityClass;

/**
 * Created by Aditya.
 */
@UtilityClass
public class EmployeeRelationshipUtil {
    public EmployeeUIModel toUIModel(Employee employee) {
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
