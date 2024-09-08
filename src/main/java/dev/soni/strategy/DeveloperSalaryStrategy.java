package dev.soni.strategy;

public class DeveloperSalaryStrategy implements SalaryStrategy {
    private int developerAppraisal = 15;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * developerAppraisal / 100);
    }
}
