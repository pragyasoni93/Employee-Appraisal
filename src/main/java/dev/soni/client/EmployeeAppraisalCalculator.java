package dev.soni.client;

import dev.soni.dataModel.DepartmentName;
import dev.soni.dataModel.Employee;
import dev.soni.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeAppraisalCalculator {
    private EmployeeService employeeService = new EmployeeService();
    public void runEmployeeDiscountApp(){
        while(true){
            showMenu();
            int choice = Integer.valueOf(getUserInput("Enter your choice: "));
            startCalculator(choice);
        }
    }

    public void showMenu(){
        System.out.println("Employee Discount Calculator");
        System.out.println("1. Add Employee");
        System.out.println("2. Display Employees With calculated Salary");
        System.out.println("3. Exit");
    }

    private String getUserInput(String inputMessage) {
        Scanner in = new Scanner(System.in);
        System.out.println(inputMessage);
        String taskNumber = in.next();
        return taskNumber;
    }

    public void startCalculator(int choice){
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

    public boolean addEmployee(){
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

    public void getAllEmployees(){
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

    public List<Employee> getEmployeesAfterAppraisals(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeService.applyEmployeeSalaryAppraisals(employeeList);
    }

}
