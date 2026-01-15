package Assignments.EcommerceSystem.com.Ecommerce;

// use this imports if you have a diferent java IDE
// import com.ecommerce.Product;
// import com.ecommerce.Customer;
// import com.ecommerce.orders.Order;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create Products
        Product p1 = new Product(1, "Windows Server", 800.00);
        Product p2 = new Product(2, "Network Attachtment Storage", 500.00);
        Product p3 = new Product(3, "Hypervisor License", 100.00);

        // Display available products
        System.out.println("Available Products:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Create Customer
        Customer customer = new Customer(101, "Alice");

        // Add Products to Cart
        customer.addToCart(p1);
        customer.addToCart(p3);

        // Remove Product (if needed)
        customer.removeFromCart(p2); // not in cart
        customer.removeFromCart(p3); // removed successfully

        // Add again for order
        customer.addToCart(p2);
        customer.addToCart(p3);

        // Calculate Cart Total
        System.out.println("\nCart Total: $" + customer.calculateTotal());

        // Place Order
        try {
            Order order = new Order(customer, customer.getShoppingCart());
            order.printOrderSummary();

            // Update Order Status
            order.updateStatus("Shipped");
            System.out.println("Updated Status: " + order.getStatus());

        } catch (Exception e) {
            System.out.println("Error placing order: " + e.getMessage());
        }
    }
}

