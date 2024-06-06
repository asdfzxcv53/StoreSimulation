package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDto {
    private String empCode;
    private String empName;
    private Long empAge;
    private String empGender;
    private String empPhoneNo;
    private String empMailNo;
    private String empAccountNo;
    private String part;
    private Long salary;
}
