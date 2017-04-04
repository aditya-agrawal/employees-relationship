package com.coviam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Aditya.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
@Entity
@Table(name = "employees")
@SolrDocument(solrCoreName = "employee")
public class Employee implements Serializable{

    @Id
    String id;

    String name;

    @DBRef
    @JoinColumn(name = "employee_id")
    @ManyToOne
    Employee manager;
}
