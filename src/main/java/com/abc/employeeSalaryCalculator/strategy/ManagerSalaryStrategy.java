package com.abc.employeeSalaryCalculator.strategy;

/**
 * Calculate the salary of Manager employee based on the appraisal percentage
 */
public class ManagerSalaryStrategy implements SalaryStrategy {
    private static final double MANAGER_APPRAISAL_PERCENT = 12;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * MANAGER_APPRAISAL_PERCENT / 100);
    }
}
