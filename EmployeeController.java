package com.example.EmployeesAssignment.Controller;

import com.example.EmployeesAssignment.Model.Employees;
import com.example.EmployeesAssignment.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employees generateEmployee(@RequestBody Employees employees){
        return employeeService.generateEmployee(employees);
    }

    @GetMapping
    public Collection<Employees>getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employees getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @PutMapping("/{id}")
    public Employees updateEmployee(@PathVariable Long id,@RequestBody Employees employees){
        return employeeService.updateEmployee(id,employees);
    }

    @DeleteMapping("/{id}")
    public Employees deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/manager")
    public Collection<Employees> getAllEmployeesAsManagerDesignation(){
        return employeeService.getAllEmployeesAsManagerDesignation();
    }

    @GetMapping("/salary")
    public Collection<Employees> getAllEmployeeswithHigherSalary(){
        return employeeService.getAllEmployeeswithHigherSalary();
    }

    @GetMapping("/evensalary")
    public Collection<Employees> getAllEmployeesWhoseSalaryDivisibleByTwo(){
        return employeeService.getAllEmployeesWhoseSalaryDivisibleByTwo();
    }
}


