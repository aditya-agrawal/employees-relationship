package com.coviam.model;

import lombok.*;

import javax.persistence.Entity;

import javax.persistence.Id;

import java.util.List;

/**
 * Created by Aditya.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    String id;
    String name;
    List<String> juniorIds;
}
