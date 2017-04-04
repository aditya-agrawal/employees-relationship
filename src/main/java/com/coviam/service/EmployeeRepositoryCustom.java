package com.coviam.service;

import com.coviam.model.Employee;
import org.springframework.data.solr.core.query.result.Cursor;

/**
 * Created by Aditya.
 */
public interface EmployeeRepositoryCustom {

    Cursor<Employee> findAllUsingCursor();
}
