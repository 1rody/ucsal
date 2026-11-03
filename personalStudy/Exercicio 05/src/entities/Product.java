package entities;

public class Product {
    private String name;
    private double price;
    private Integer quantity;

    public Product(String name, double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //total de de produtos valor
    public double calcTotalValue() {
        double totalValue = 0;
        totalValue += price * quantity;
        return totalValue;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
