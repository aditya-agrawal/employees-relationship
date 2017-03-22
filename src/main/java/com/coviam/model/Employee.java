package com.coviam.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Aditya.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee {
    @Id
    String id;

    String name;

    @Column(name = "junior_ids")
    List<String> juniorIds;
}
