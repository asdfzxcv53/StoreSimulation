package com.example.store.mapper;

import com.example.store.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    public List<EmployeeDto> SelectAllEmployee();
    public void InsertEmployee(EmployeeDto employeeDto);
    public void UpdateEmployee(EmployeeDto employeeDto);
    public void DeleteEmployeeByCode(String empCode);
    public EmployeeDto SelectEmployeeByCode(String empCode);
}
