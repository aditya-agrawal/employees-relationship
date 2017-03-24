package com.coviam.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Aditya.
 */
@Data
@Builder
public class EmployeeUIModel {
    String managerId;
    String id;
    String name;
}
