package com.example.store.repository;

import com.example.store.dto.EmployeeDto;
import com.example.store.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EmployeeDto> SelectAllEmployee(){
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EmployeeDto.class));
    }

    public EmployeeDto SelectEmployeeByCode(String empCode){
        String sql = "select * from employee where EMP_CODE = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EmployeeDto.class), empCode);
    }

    public EmployeeDto SelectEmployeeByName(String empName){
        String sql = "select * from employee where EMP_NAME = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EmployeeDto.class), empName);
    }

    public void InsertEmployee(EmployeeDto employeeDto){
        String sql = "insert into Employee values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employeeDto.getEmpCode(), employeeDto.getEmpName(),employeeDto.getEmpAge(), employeeDto.getEmpGender(), employeeDto.getEmpPhoneNo(), employeeDto.getEmpMailNo(), employeeDto.getEmpAccountNo(), employeeDto.getPart(), employeeDto.getSalary());
    }

    public void UpdateEmployee(EmployeeDto employeeDto){
        String sql = "update employee set emp_name = ?, emp_age = ?, emp_gender = ?, emp_phone_no = ?, emp_mail_no = ?, emp_account_no = ?, part = ?, salary = ? where EMP_CODE = ?";
        jdbcTemplate.update(sql, employeeDto.getEmpName(), employeeDto.getEmpAge(), employeeDto.getEmpGender(), employeeDto.getEmpPhoneNo(), employeeDto.getEmpMailNo(), employeeDto.getEmpAccountNo(), employeeDto.getPart(), employeeDto.getSalary(), employeeDto.getEmpCode());
    }

    public void DeleteEmployee(String empCode){
        String sql = "delete from employee where EMP_CODE = ?";
        jdbcTemplate.update(sql, empCode);
    }
}
