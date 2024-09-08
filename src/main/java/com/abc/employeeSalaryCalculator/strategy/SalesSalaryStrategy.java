package com.abc.employeeSalaryCalculator.strategy;

/**
 * Calculate the salary of sales employee based on the appraisal percentage
 */
public class SalesSalaryStrategy implements SalaryStrategy {
    private static final double SALES_APPRAISAL_PERCENT = 10;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * SALES_APPRAISAL_PERCENT / 100);
    }
}
