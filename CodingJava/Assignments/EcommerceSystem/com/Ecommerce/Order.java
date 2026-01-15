/**
 * This project uses auto importing feature fron the vs code java extension pack
 * and those import are done on the background, therefore they won't show up here. 
 * If you use a different IDE please, make sure your import procedure works properly
 * importing the bellow packages extension:
 */

package Assignments.EcommerceSystem.com.Ecommerce;

// import com.Ecommerce.Product;
// import com.Ecommerce.Customer;

import java.util.List;
import java.util.UUID;

public class Order {
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private double total;
    private String status;

    public Order(Customer customer, List<Product> products) {
        this.orderID = UUID.randomUUID().toString();
        this.customer = customer;
        this.products = products;
        this.total = calculateTotal();
        this.status = "Placed";
    }

    private double calculateTotal() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void printOrderSummary() {
        System.out.println("\nOrder Summary:");
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product p : products) {
            System.out.println(" - " + p.getName() + ": $" + p.getPrice());
        }
        System.out.println("Total: $" + total);
        System.out.println("Status: " + status);
    }

    public String getStatus() {
        return status;
    }
}
