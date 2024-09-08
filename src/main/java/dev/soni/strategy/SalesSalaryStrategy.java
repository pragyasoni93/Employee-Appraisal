package dev.soni.strategy;

public class SalesSalaryStrategy implements SalaryStrategy {
    private int salesAppraisal = 10;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * salesAppraisal / 100);
    }
}
