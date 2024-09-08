package dev.soni.context;

import dev.soni.strategy.SalaryStrategy;

public class Appraisal {
    SalaryStrategy salaryStrategy;

    public void setDiscountStrategy(SalaryStrategy salaryStrategy){
        this.salaryStrategy = salaryStrategy;
    }

    public double calculateSalary(double salary){
        return salaryStrategy.calculateIncrementedSalary(salary);
    }
}
