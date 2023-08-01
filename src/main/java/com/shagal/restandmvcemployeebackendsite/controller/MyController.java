package com.shagal.restandmvcemployeebackendsite.controller;

import com.shagal.restandmvcemployeebackendsite.entity.Employee;
import com.shagal.restandmvcemployeebackendsite.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/")
    public String welcomePage() {
        return "main";
    }
    @RequestMapping("/mvc")
    public String mvcView(Model model) {
        List<Employee> allEmps = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmps);
        return "mvc";
    }
    @RequestMapping("/updateEmpInfo/{id}")
    public String updateEmpInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "updateEmpInfo";
    }
    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/mvc";
    }
}
