package com.coviam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

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
public class Employee {
    @Id
    String id;

    String name;

    @ElementCollection(targetClass = String.class)
    @Column(name = "junior_ids")
    List<String> juniorIds;
}
