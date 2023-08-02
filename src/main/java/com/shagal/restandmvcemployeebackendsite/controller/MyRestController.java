package com.shagal.restandmvcemployeebackendsite.controller;

import com.shagal.restandmvcemployeebackendsite.entity.Employee;
import com.shagal.restandmvcemployeebackendsite.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/json")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployees(@PathVariable int id) {
        return employeeService.getEmployee(id);
        }
    @PostMapping("/")
    public Employee addNewEmployee(@RequestBody Employee employeeToAdd) {
        employeeService.saveEmployee(employeeToAdd);
        return employeeToAdd;
    }
    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employeeToUpdate) {
        employeeService.saveEmployee(employeeToUpdate);
        return employeeToUpdate;
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " was deleted";
    }

}
