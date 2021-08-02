package com.example.springmongodb.controller;

import com.example.springmongodb.model.Employee;
import com.example.springmongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 02-08-2021
 * Time: 18:26
 * Year: 2021
 * Project: spring-mongodb
 * Package: com.example.springmongodb.controller
 */
@RestController
@RequestMapping(value = "/api/persons" , produces = {MediaType.APPLICATION_JSON_VALUE})
public class EmployeeController {

    private final EmployeeService employeeService;

    @Lazy
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> insertEmp(@RequestBody Employee employee){

        Employee e = employeeService.createEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(e.getEmpId())
                .toUri();
        return ResponseEntity.created(location).body(e);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable("id") String id){
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PutMapping(path = "/update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> updateEmp(@PathVariable("id") String id, @RequestBody Employee employee){

        Optional<Employee> e = employeeService.findEmployeeById(id);
        Employee res = null;
        if (e.isPresent()){
            res  = employeeService.updateEmployee(employee);
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().replacePath("/api/persons")
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).body(res);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") String id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
}
