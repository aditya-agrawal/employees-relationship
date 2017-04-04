package com.coviam.service;

import com.coviam.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.Cursor;

/**
 * Created by Aditya.
 */
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @Autowired
    private SolrTemplate solrTemplate;

    @Override
    public Cursor<Employee> findAllUsingCursor() {
        return solrTemplate.queryForCursor(new SimpleQuery("xyz"), Employee.class);
    }
}
