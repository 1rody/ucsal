package entities;

public class Employee {


    private Integer id;
    private String name;
    private double hours;
    private double valuePerHour;

    public Employee() {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public double payment() {
        double paymentP = hours * valuePerHour;
        return paymentP;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHours() {
        return hours;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }
}
