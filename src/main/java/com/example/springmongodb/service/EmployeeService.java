package com.example.springmongodb.service;

import com.example.springmongodb.model.Employee;
import com.example.springmongodb.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 02-08-2021
 * Time: 18:55
 * Year: 2021
 * Project: spring-mongodb
 * Package: com.example.springmongodb.service
 */
@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public Employee createEmployee(Employee e){
        return employeeDao.createEmployee(e);
    }

    public List<Employee> getAllEmployee(){
        return (List<Employee>) employeeDao.getAllEmployee();
    }

    public Optional<Employee> findEmployeeById(String uuid){
        return employeeDao.findEmployeeById(uuid);
    }

    public Employee updateEmployee(Employee employee){
        return employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeDao.deleteEmployee(employee);
    }

    public void deleteEmployeeById(String id){
        employeeDao.deleteEmployeeById(id);
    }
}
