package com.shagal.restandmvcemployeebackendsite.controller;

import com.shagal.restandmvcemployeebackendsite.entity.Employee;
import com.shagal.restandmvcemployeebackendsite.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/json")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
