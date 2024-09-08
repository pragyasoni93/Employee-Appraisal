package com.abc.employeeSalaryCalculator.strategy;

/**
 * Calculate the salary of Operations employee based on the appraisal percentage
 */
public class OperationsSalaryStrategy implements SalaryStrategy {
    private static final double OPERATIONS_APPRAISAL_PERCENT = 8;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * OPERATIONS_APPRAISAL_PERCENT / 100);
    }
}
