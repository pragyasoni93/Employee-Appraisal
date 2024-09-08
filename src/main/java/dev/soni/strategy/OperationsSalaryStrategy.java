package dev.soni.strategy;

public class OperationsSalaryStrategy implements SalaryStrategy {
    private int operationsAppraisal = 8;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * operationsAppraisal / 100);
    }
}
