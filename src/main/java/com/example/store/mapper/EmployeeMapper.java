package com.example.store.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT count(*) FROM EMPLOYEE")
    public int getCnt();
}
