package com.abc.employeeSalaryCalculator.strategy;

public interface SalaryStrategy {
    /**
     * Calculate incremented salary based on the departments.
     * @param salary
     * @return
     */
    double calculateIncrementedSalary( double salary);
}
