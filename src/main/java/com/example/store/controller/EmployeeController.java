package com.example.store.controller;

import com.example.store.dto.EmployeeDto;
import com.example.store.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> InsertEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.InsertEmployee(employeeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> UpdateEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.UpdateEmployee(employeeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deregist")
    public ResponseEntity<?> DeleteEmployeeByCode(@RequestBody Map<String, List<String>> employeeCodeList){
        try {
            List<String> codes = employeeCodeList.get("selectedEmployees");
            for (String empCode : codes) {
                employeeService.DeleteEmployeeByCode(empCode);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting employees: " + e.getMessage());
        }
    }
}


