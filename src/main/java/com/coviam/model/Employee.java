package com.coviam.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Aditya.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    String id;
    String name;
    @ElementCollection(targetClass = String.class)
    @Column(name = "junior_ids")
    @Singular
    List<String> juniorIds;
}
