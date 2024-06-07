package com.example.store.service;

import com.example.store.dto.EmployeeDto;
import com.example.store.mapper.EmployeeMapper;
import com.example.store.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDto> SelectAllEmployee() {
        return employeeMapper.SelectAllEmployee();
    }

    public void InsertEmployee (EmployeeDto employeeDto) {
        employeeMapper.InsertEmployee(employeeDto);
    }
}
