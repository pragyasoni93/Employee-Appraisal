package com.abc.employeeSalaryCalculator.strategy;

/**
 * Calculate the salary of Developer employee based on the appraisal percentage
 */
public class DeveloperSalaryStrategy implements SalaryStrategy {
    private static final double DEVELOPER_APPRAISAL_PERCENT = 15;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * DEVELOPER_APPRAISAL_PERCENT / 100);
    }
}
