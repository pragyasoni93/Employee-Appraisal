package dev.soni.dataModel;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String employeeName;
    private DepartmentName departmentname;
    private double Salary;

    private static int idCounter = 0;

    public Employee(String employeeName, DepartmentName departmentname, double salary) {
        this.id = getAutoIdCounter();
        this.employeeName = employeeName;
        this.departmentname = departmentname;
        Salary = salary;
    }

    public static int getAutoIdCounter() {
        idCounter++;
        return idCounter;
    }
}
