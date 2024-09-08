package com.abc.employeeSalaryCalculator.service;

import com.abc.employeeSalaryCalculator.dao.EmployeeRepository;
import com.abc.employeeSalaryCalculator.strategy.*;
import com.abc.employeeSalaryCalculator.context.Appraisal;
import com.abc.employeeSalaryCalculator.dataModel.Employee;
import dev.soni.strategy.*;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    /**
     * Add Employee to the Employee list.
     * @param employee
     * @return
     */
    @Override
    public boolean addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    /**
     * Get all the employees from the Employee list.
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    /**
     * Apply Employee Salary Appraisals based on the department.
     * @param employees
     * @return
     */
    @Override
    public List<Employee> applyEmployeeSalaryAppraisals(List<Employee> employees) {
        List<Employee> employeeList = getAllEmployees();
        for(Employee employee : employeeList){
            Appraisal appraisal = new Appraisal();
            switch (employee.getDepartmentname()) {
                case MANAGER -> {
                    getAppraisalStrategy(appraisal, new ManagerSalaryStrategy(), employee);
                }
                case SALES -> {
                    getAppraisalStrategy(appraisal, new SalesSalaryStrategy(), employee);
                }
                case OPERATIONS -> {
                    getAppraisalStrategy(appraisal, new OperationsSalaryStrategy(), employee);
                }
                case DEVELOPER -> {
                    getAppraisalStrategy(appraisal, new DeveloperSalaryStrategy(), employee);
                }
                default -> throw new IllegalStateException("Please Enter the correct department Name " + employee.getDepartmentname());
            }
        }
        return employeeList;
    }

    /**
     * Get the Appraisal Strategy based on the department.
     * @param appraisal
     * @param salaryStrategy
     * @param employee
     */
    private void getAppraisalStrategy(Appraisal appraisal, SalaryStrategy salaryStrategy, Employee employee){
        appraisal.setDiscountStrategy(salaryStrategy);
        employee.setSalary(appraisal.calculateSalary(employee.getSalary()));
    }
}
