package dev.soni.service;

import dev.soni.context.Appraisal;
import dev.soni.dao.EmployeeRepository;
import dev.soni.dataModel.Employee;
import dev.soni.strategy.*;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public List<Employee> applyEmployeeSalaryAppraisals(List<Employee> employees) {
        List<Employee> employeeList = getAllEmployees();
        for(Employee employee : employeeList){
            Appraisal appraisal = new Appraisal();
            switch (employee.getDepartmentname().toString()) {
                case "MANAGER" -> {
                    getAppraisalStrategy(appraisal, new ManagerSalaryStrategy(), employee);
                }
                case "SALES" -> {
                    getAppraisalStrategy(appraisal, new SalesSalaryStrategy(), employee);
                }
                case "OPERATIONS" -> {
                    getAppraisalStrategy(appraisal, new OperationsSalaryStrategy(), employee);
                }
                case "DEVELOPER" -> {
                    getAppraisalStrategy(appraisal, new DeveloperSalaryStrategy(), employee);
                }
                default -> throw new IllegalStateException("Please Enter the correct department Name " + employee.getDepartmentname());
            }
        }
        return employeeList;
    }

    public void getAppraisalStrategy(Appraisal appraisal, SalaryStrategy salaryStrategy, Employee employee){
        appraisal.setDiscountStrategy(salaryStrategy);
        employee.setSalary(appraisal.calculateSalary(employee.getSalary()));
    }
}
