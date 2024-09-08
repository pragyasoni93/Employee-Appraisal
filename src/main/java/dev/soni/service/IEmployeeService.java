package dev.soni.service;

import dev.soni.dataModel.Employee;

import java.util.List;

public interface IEmployeeService {

    boolean addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    List<Employee> applyEmployeeSalaryAppraisals(List<Employee> employees);
}
