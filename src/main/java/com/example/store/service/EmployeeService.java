package com.example.store.service;

import com.example.store.dto.EmployeeDto;
import com.example.store.mapper.EmployeeMapper;
import com.example.store.repository.EmployeeRepository;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final CodeSequence codeSequence;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper, CodeSequence codeSequence) {
        this.employeeMapper = employeeMapper;
        this.codeSequence = codeSequence;
    }

    public List<EmployeeDto> SelectAllEmployee() {
        return employeeMapper.SelectAllEmployee();
    }

    public EmployeeDto SelectEmployeeByCode(String empCode) {
        return employeeMapper.SelectEmployeeByCode(empCode);
    }

    public void InsertEmployee (EmployeeDto employeeDto) {
        employeeDto.setEmpCode(codeSequence.generateEmployeeCode());
        if(employeeDto.getPart().equals("D"))
            employeeDto.setSalary(1680000L);
        else employeeDto.setSalary(2240000L);
        employeeMapper.InsertEmployee(employeeDto);
    }

    public void UpdateEmployee (EmployeeDto employeeDto) {
        employeeMapper.UpdateEmployee(employeeDto);
    }
    public void DeleteEmployeeByCode (String empCode) {
        employeeMapper.DeleteEmployeeByCode(empCode);
    }
}
