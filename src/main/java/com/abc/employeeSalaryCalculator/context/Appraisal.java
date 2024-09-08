package com.abc.employeeSalaryCalculator.context;

import com.abc.employeeSalaryCalculator.strategy.SalaryStrategy;

/**
 * Context class for setting the appraisal strategy and calculating the salary based on the department.
 */
public class Appraisal {
    SalaryStrategy salaryStrategy;

    /**
     * Set the appraisal strategy object as per the department.
     * @param salaryStrategy
     */
    public void setDiscountStrategy(SalaryStrategy salaryStrategy){
        this.salaryStrategy = salaryStrategy;
    }

    /**
     * Calculate the salary as per the calculation defined in the different strategy based on the department.
     * @param salary
     * @return
     */
    public double calculateSalary(double salary){
        return salaryStrategy.calculateIncrementedSalary(salary);
    }
}
