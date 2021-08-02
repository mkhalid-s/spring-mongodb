package com.example.springmongodb.repository;

import com.example.springmongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 02-08-2021
 * Time: 18:27
 * Year: 2021
 * Project: spring-mongodb
 * Package: com.example.springmongodb.repository
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
