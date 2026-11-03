package services;

import entities.Employee;

import java.util.ArrayList;

public class Company {
    public ArrayList<Employee> employees;

    public Company() {
       this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
    public double calculateTotalPayroll() {
        double total =0;
        for(Employee employee : employees) {
            total += employee.getSalary();
        }
        return  total;
    }
    public Employee findHighestPaidEmployee() {
        if (employees.isEmpty()) {
            return null;
        }

        Employee highestPaid = employees.get(0);

        for (Employee employee : employees) {
            if (employee.getSalary() > highestPaid.getSalary()) {
                highestPaid = employee;
            }
        }

        return highestPaid;
    }
}
