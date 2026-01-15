package Assignments;

import java.util.*;

// Generic LibraryItem class
class LibraryItem<T> {
    private String title;
    private String author;
    private String itemID;
    private T itemType;  // To differentiate between types (Book, DVD, etc.)

    public LibraryItem(String title, String author, String itemID, T itemType) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
        this.itemType = itemType;
    }

    public String getItemID() {
        return itemID;
    }

    public String getDetails() {
        return "Item ID: " + itemID +
                ", Title: " + title +
                ", Author: " + author +
                ", Type: " + itemType.toString();
    }
}

// Generic Catalog class
class LibraryCatalog<T extends LibraryItem<?>> {
    private Map<String, T> catalog;

    public LibraryCatalog() {
        catalog = new HashMap<>();
    }

    public void addItem(T item) {
        if (catalog.containsKey(item.getItemID())) {
            System.out.println("Error: Item ID already exists.");
        } else {
            catalog.put(item.getItemID(), item);
            System.out.println("Item added successfully.");
        }
    }

    public void removeItem(String itemID) {
        if (catalog.containsKey(itemID)) {
            catalog.remove(itemID);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Error: Item not found.");
        }
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is currently empty.");
        } else {
            for (T item : catalog.values()) {
                System.out.println(item.getDetails());
            }
        }
    }

    public boolean isEmpty() {
        return catalog.isEmpty();
    }
}

// Enum for item types
enum ItemType {
    BOOK,
    DVD,
    MAGAZINE
}

// Main class 
public class GenericLibraryCatalogApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibraryCatalog<LibraryItem<ItemType>> catalog = new LibraryCatalog<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== Library Catalog Menu ====");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Run Tests");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addItemUI(catalog);
                    break;
                case "2":
                    removeItemUI(catalog);
                    break;
                case "3":
                    catalog.displayCatalog();
                    break;
                case "4":
                    runTests();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addItemUI(LibraryCatalog<LibraryItem<ItemType>> catalog) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();

        System.out.print("Enter item type (BOOK, DVD, MAGAZINE): ");
        String typeInput = scanner.nextLine().toUpperCase();

        try {
            ItemType itemType = ItemType.valueOf(typeInput);
            LibraryItem<ItemType> item = new LibraryItem<>(title, author, itemID, itemType);
            catalog.addItem(item);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid item type. Please enter BOOK, DVD, or MAGAZINE.");
        }
    }

    private static void removeItemUI(LibraryCatalog<LibraryItem<ItemType>> catalog) {
        System.out.print("Enter the Item ID to remove: ");
        String itemID = scanner.nextLine();
        catalog.removeItem(itemID);
    }

    private static void runTests() {
        System.out.println("\nRunning test cases...");
        LibraryCatalog<LibraryItem<ItemType>> testCatalog = new LibraryCatalog<>();

        // Test 1: Add items
        LibraryItem<ItemType> book1 = new LibraryItem<>("1984", "Isasc Newton", "B001", ItemType.BOOK);
        LibraryItem<ItemType> dvd1 = new LibraryItem<>("Inception: Spaider Man 7", "Chris Boita", "D001", ItemType.DVD);
        testCatalog.addItem(book1);
        testCatalog.addItem(dvd1);

        // Test 2: Duplicate ID
        LibraryItem<ItemType> duplicateBook = new LibraryItem<>("Beatiful Spanish", "Africa Bioko", "B001", ItemType.BOOK);
        testCatalog.addItem(duplicateBook);

        // Test 3: Display items
        // testCatalog.displayCatalog();

        // Test 4: Remove existing and non-existing item
        testCatalog.removeItem("D001");
        testCatalog.removeItem("X999");

        // Test 5: Display catalog after removal
        testCatalog.displayCatalog();

        System.out.println("All tests completed.");
    }
}

