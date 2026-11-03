package entities;

public class OutsourcedEmployee extends Employee {
    private double additionalCharge;

    public OutsourcedEmployee(Integer id, String name, double hours, double valuePerHour, double additionalCharge) {
        super(id, name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment() {
        return super.payment() + (additionalCharge * 1.10);
    }
}
