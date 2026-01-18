package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;

import java.awt.*;
import java.util.List;


public interface EmployeeService {

    //addemployee
        EmployeeDto createEmployee(EmployeeDto employeeDto); //Dto start because data transfer object
//get employee by ID
 EmployeeDto getEmployeeById(Long employeeid);

 //getAllemployees
    List<EmployeeDto> getAllEmployees();
//updateEmployee
    EmployeeDto updateEmployee(Long employeeid ,  EmployeeDto updatedEmployeeDto);

    //delete
void deleteEmployee(Long employeeid);
}
