package com.example.store.service;

import com.example.store.dto.EmployeeDto;
import com.example.store.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> SelectAllEmployee() {
        return employeeRepository.SelectAllEmployee();
    }

    public EmployeeDto SelectEmployeeByCode(String empCode) {
        return employeeRepository.SelectEmployeeByCode(empCode);
    }

    public EmployeeDto SelectEmployeeByName(String empName) {
        return employeeRepository.SelectEmployeeByName(empName);
    }

    public void InsertEmployee(EmployeeDto employeeDto) {
        employeeRepository.InsertEmployee(employeeDto);
    }

    public void UpdateEmployee(EmployeeDto employeeDto) {
        employeeRepository.UpdateEmployee(employeeDto);
    }

    public void DeleteEmployee(String empCode) {
        employeeRepository.DeleteEmployee(empCode);
    }
}
