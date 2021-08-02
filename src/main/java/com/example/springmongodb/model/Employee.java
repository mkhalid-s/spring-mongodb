package com.example.springmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 02-08-2021
 * Time: 18:21
 * Year: 2021
 * Project: spring-mongodb
 * Package: com.example.springmongodb.model
 */
@EntityScan
@Document(collection = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    private String empId;

    @NonNull
    private String firstName;

    private String middleName;

    @NonNull
    private String lastName;

    @NonNull
    private String department;

}
