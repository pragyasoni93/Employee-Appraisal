package com.abc.employeeSalaryCalculator.dao;

import com.abc.employeeSalaryCalculator.dataModel.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EmployeeRepository {
    private List<Employee> employeeDB = new ArrayList<>();

    public boolean addEmployee(Employee employee){
        return employeeDB.add(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeDB;
    }

}
