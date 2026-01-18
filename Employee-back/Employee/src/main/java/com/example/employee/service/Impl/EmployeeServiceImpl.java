package com.example.employee.service.Impl;


import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.exception.ResourceNotFound;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeRepo;
import com.example.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor//injecting

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeRepo empRepo; //injecting

    @Override //post
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

       Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
       Employee savedEmployee = empRepo.save(employee);
       return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override //GetById
    public EmployeeDto getEmployeeById(Long employeeid) {

        Employee employee =  empRepo.findById(employeeid).orElseThrow
                (() -> new ResourceNotFound("Employee not found With Given Id " + employeeid));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override //GetAll
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = empRepo.findAll(); //id eken gnnkot fast nisa
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override //Update
    public EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedEmployeeDto) {
        Employee employee = empRepo.findById(employeeid)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with Given Id " + employeeid));

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());

        Employee updatedEmployeeObj = empRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override //Delete
    public void deleteEmployee(Long employeeid) {
        Employee employee = empRepo.findById(employeeid)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with Given Id " + employeeid));
        empRepo .deleteById(employeeid);
    }


}





