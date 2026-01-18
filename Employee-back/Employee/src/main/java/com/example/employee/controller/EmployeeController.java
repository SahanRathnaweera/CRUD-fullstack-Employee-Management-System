package com.example.employee.controller;

import com.example.employee.dto.EmployeeDto;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor //injected
@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")

public class EmployeeController {

    private EmployeeService employeeService; //injected (interface)


    //ADD EMPLOYEE REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto) {
     EmployeeDto savedEmployee =   employeeService.createEmployee(employeeDto);
     return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
 //getEmployeeBuyId

    @GetMapping("{id}") //c-D
    public ResponseEntity<EmployeeDto> getEmployeeByiD (@PathVariable("id") Long employeeId) {
     EmployeeDto employeeDto =  employeeService.getEmployeeById(employeeId);
      return ResponseEntity.ok(employeeDto);
    }

    //getall
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);

    }

    //update
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee   (@PathVariable ("id") Long employeeId ,
                                                         @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
 return ResponseEntity.ok(employeeDto);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted");
    }
}
