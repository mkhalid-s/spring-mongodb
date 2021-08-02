package com.example.springmongodb.repository;

import com.example.springmongodb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 02-08-2021
 * Time: 18:29
 * Year: 2021
 * Project: spring-mongodb
 * Package: com.example.springmongodb.repository
 */
@Component
public class EmployeeDao {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDao(@Lazy EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee e){
       return employeeRepository.insert(e);
    }

    public Collection<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(String uuid){
        return employeeRepository.findById(uuid);
    }

    public Employee updateEmployee(Employee employee){
        Optional<Employee> findEmployee = employeeRepository.findById(employee.getEmpId());

        if (findEmployee.isPresent()){
            Employee e = findEmployee.get();
            e.setFirstName(employee.getFirstName());
            e.setMiddleName(employee.getMiddleName());
            e.setLastName(employee.getLastName());
            e.setDepartment(employee.getDepartment());

            return employeeRepository.save(e);
        }else{
            return null;
        }
    }

    public boolean deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
        return true;
    }

    public void deleteEmployeeById(String uuid){
        employeeRepository.deleteById(uuid);
    }
}

