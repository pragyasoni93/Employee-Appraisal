package dev.soni.strategy;

public class ManagerSalaryStrategy implements SalaryStrategy {
    private int managerAppraisal = 12;
    @Override
    public double calculateIncrementedSalary(double salary) {
        return salary + (salary * managerAppraisal / 100);
    }
}
