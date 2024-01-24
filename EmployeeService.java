package com.example.EmployeesAssignment.Service;

import com.example.EmployeesAssignment.Model.Employees;
import org.springframework.stereotype.Service;

import java.rmi.StubNotFoundException;
import java.util.*;

@Service
public class EmployeeService {
    Map<Long, Employees> employees = new HashMap<>();

    Long id=1L;

    public Employees generateEmployee(Employees employee){
        employee.setEmployeeId(id++);
        employees.put(employee.getEmployeeId(),employee);
        return employee;
    }

    public Collection<Employees> getAllEmployees(){
        return employees.values();
    }

    public Employees getEmployee(Long id){
        Employees employee = employees.get(id);
        return employee;
    }

    public Employees updateEmployee(Long id, Employees employee){
        employee.setEmployeeId(id);
        Employees emp = employees.get(id);
        if(emp!=null){
           employees.put(id,employee);
           return employee;
        }else{
            return new Employees();
        }
    }

    public Employees deleteEmployee(Long id){
        Employees employee = employees.get(id);
        if(employee!=null){
            Employees emp = employees.remove(id);
            return emp;
        }else{
            return new Employees();
        }
    }

    public List<Employees> getAllEmployeesAsManagerDesignation() {
        Collection<Employees> employeesManager = employees.values();
        List<Employees> arrayList = new ArrayList<>();
        for (Employees employees:employeesManager) {
            if(employees.getEmployeeDesignation().equalsIgnoreCase("manager")){
                arrayList.add(employees);
            }
        }
        return arrayList;
    }

    public Collection<Employees> getAllEmployeeswithHigherSalary() {
        Collection<Employees> employeesSalary = employees.values();
        List<Employees> arrayList = new ArrayList<>();
        for (Employees employees:employeesSalary){
            if(employees.getEmployeeSalary()>10000){
                arrayList.add(employees);
            }
        }
        return arrayList;
    }

    public Collection<Employees> getAllEmployeesWhoseSalaryDivisibleByTwo() {
        Collection<Employees> employeesSalary = employees.values();
        List<Employees> arrayList = new ArrayList<>();
        for (Employees employees:employeesSalary){
            if(employees.getEmployeeSalary()%2==0){
                arrayList.add(employees);
            }
        }
        return arrayList;
    }
}
