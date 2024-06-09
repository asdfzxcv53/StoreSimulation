package com.example.store.controller;

import com.example.store.dto.EmployeeDto;
import com.example.store.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/update")
    public ResponseEntity<?> UpdateEmployee(EmployeeDto employeeDto){
        employeeService.UpdateEmployee(employeeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deregist")
    public ResponseEntity<?> DeleteEmployeeByCode(@RequestParam Map<String, List<String>> employeeCodeMap){
        for (Map.Entry<String, List<String>> entry : employeeCodeMap.entrySet()) {
            for (String empCode : entry.getValue()) {
                employeeService.DeleteEmployeeByCode(empCode);
            }
        }
        return ResponseEntity.ok().build();
    }
}
