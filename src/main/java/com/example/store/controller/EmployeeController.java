package com.example.store.controller;

import com.example.store.dto.EmployeeDto;
import com.example.store.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDto> SelectAllEmployee() {
        return employeeService.SelectAllEmployee();
    }

    @PostMapping("/regist")
    public void InsertEmployee(EmployeeDto employeeDto){
        employeeService.InsertEmployee(employeeDto);
    }
}
