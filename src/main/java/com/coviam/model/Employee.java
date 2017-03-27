package com.coviam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

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
public class Employee extends JdkSerializationRedisSerializer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    String id;

    String name;

    @DBRef
    @JoinColumn(name = "employee_id")
    @ManyToOne
    Employee manager;
}
