package com.abc.employeeSalaryCalculator.service;

import com.abc.employeeSalaryCalculator.dataModel.Employee;

import java.util.List;

/**
 * Inteface for EmployeeService class to add employee, get all employees and apply salary appraisals
 */
public interface IEmployeeService {

    boolean addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    List<Employee> applyEmployeeSalaryAppraisals(List<Employee> employees);
}
