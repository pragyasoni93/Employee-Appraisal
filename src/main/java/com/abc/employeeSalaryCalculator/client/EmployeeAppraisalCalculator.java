package com.abc.employeeSalaryCalculator.client;

import com.abc.employeeSalaryCalculator.dataModel.DepartmentName;
import com.abc.employeeSalaryCalculator.service.EmployeeService;
import com.abc.employeeSalaryCalculator.dataModel.Employee;

import java.util.List;
import java.util.Scanner;

/**
 * This class acts as a controller of the application.
 * It takes input from the user and calls the appropriate service methods.
 * It also displays the final employee list to the user after applying the appraisals.
 */
public class EmployeeAppraisalCalculator {
    private EmployeeService employeeService = new EmployeeService();
    public void runEmployeeDiscountApp(){
        while(true){
            showMenu();
            int choice = Integer.valueOf(getUserInput("Enter your choice: "));
            startCalculator(choice);
        }
    }

    /**
     * This method displays the menu to the user.
     */
    private void showMenu(){
        System.out.println("Employee Discount Calculator");
        System.out.println("1. Add Employee");
        System.out.println("2. Display Employees With calculated Salary");
        System.out.println("3. Exit");
    }

    /**
     * This method takes input from the user.
     * @param inputMessage
     * @return
     */
    private String getUserInput(String inputMessage) {
        Scanner in = new Scanner(System.in);
        System.out.println(inputMessage);
        String taskNumber = in.next();
        return taskNumber;
    }

    /**
     * This method calls the method to perform the actions from the menu.
     * @param choice
     */
    private void startCalculator(int choice){
        switch(choice){
            case 1:
                addEmployee();
                break;
            case 2:
                getAllEmployees();
                break;
            default:
                System.exit(0);
        }
    }

    /**
     * This method adds an employee to the list.
     * @return
     */
    private boolean addEmployee(){
        String employeeName = getUserInput("Enter Employee Name: ");
        String departmentName = getUserInput("Enter Department name (Sales, Manager, Operations, Developer): ");
        double employeeSalary = Double.parseDouble(getUserInput("Enter Employee Salary: "));

        DepartmentName department;
        try{
            department = DepartmentName.valueOf(departmentName.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Invalid Department Name. Please enter a valid department name.");
            departmentName = getUserInput("Enter Department name (Sales, Manager, Operations, Developer): ");
            department = DepartmentName.valueOf(departmentName.toUpperCase());
        }
        Employee employee =  new Employee(employeeName, department, employeeSalary);
        return employeeService.addEmployee(employee);
    }

    /**
     * This method displays the final list of employees after applying the appraisals.
     */
    private void getAllEmployees(){
        List<Employee> employeeList = getEmployeesAfterAppraisals();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("NAME                    " + " | " + "DEPARTMENT       " + " | " + "SALARY      ");
        System.out.println("-------------------------------------------------------------------------------");
        employeeList.forEach(employee -> {
            System.out.println(employee.getEmployeeName() + "                      |"
                    + employee.getDepartmentname() + "          |"
                    + employee.getSalary());
        });
        System.out.println("-------------------------------------------------------------------------------");
    }

    /**
     * This method applies the appraisals to the employees and returns the final list.
     * @return
     */
    private List<Employee> getEmployeesAfterAppraisals(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeService.applyEmployeeSalaryAppraisals(employeeList);
    }

}
