package Assignments.EcommerceSystem.com.Ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerID;
    private String name;
    private List<Product> shoppingCart;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    public void addToCart(Product product) {
        shoppingCart.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeFromCart(Product product) {
        if (shoppingCart.remove(product)) {
            System.out.println(product.getName() + " removed from cart.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }
}

