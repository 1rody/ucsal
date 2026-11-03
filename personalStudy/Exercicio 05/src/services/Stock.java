package services;

import entities.Product;

import java.util.ArrayList;

public class Stock {
    private ArrayList <Product> product;

    //construtor
    public Stock(ArrayList<Product> product) {
        this.product = product;
    }

    //methods
    public void addProduct(String productName, double ProductPrice, Integer ProductQuantity) {
        Product product = new Product(productName, ProductPrice, ProductQuantity);
        this.product.add(product);
    }
    public void removeProduct(String productName) {
        for (Product p : product) {
            if (p.getName().equals(productName)) {
                product.remove(p);
            }
        }
    }
    public Product findProduct(String productName) {
        for (Product p : product) {
            if (p.getName().equals(productName)) {
                return p;
            }
        }
        return null;
    }
    public double calcTotalStock() {
        double total = 0;
        for (Product p : product) {
            total += p.calcTotalValue();
        }
        return total;
    }
    public Product mostExpensiveProduct() {
        Product mostExpensive = product.getFirst();

        for (Product p : product) {
            if (p.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = p;
            }
        }
        return mostExpensive;
    }

}

