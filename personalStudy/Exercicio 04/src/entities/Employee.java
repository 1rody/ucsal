package entities;

public class Employee {
    //variaveis que compoem um funcionario
    private String name;
    private String role;
    private double salary;

    public Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double percentage) {
        salary += percentage;
    }

    @Override
    public String toString() {
        return "employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }
}
