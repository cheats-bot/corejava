/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET C - Question 1:
 * Write a Java program to build a system that maintains a list of products with:
 * a) Product ID, name, category, and stock quantity.
 * b) Quickly fetch all products by category.
 * c) Prevent duplicate product IDs.
 * d) Display products sorted by stock quantity.
 * 
 * Hint: Choose collections that balance fast lookup with sorted traversal.
 */

import java.util.*;

class Product {
    int id;
    String name;
    String category;
    int stockQuantity;

    public Product(int id, String name, String category, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    public void display() {
        System.out.printf("  [ID: %-3d] %-18s | Category: %-12s | Stock: %-4d\n",
            id, name, category, stockQuantity);
    }
}

public class ProductCatalogSystem {
    // Map of ProductID -> Product to ensure uniqueness (prevent duplicate IDs)
    private Map<Integer, Product> productMap = new HashMap<>();
    
    // Map of Category -> List<Product> for quick category lookups
    private Map<String, List<Product>> categoryMap = new HashMap<>();

    public boolean addProduct(Product p) {
        // c) Prevent duplicate product IDs
        if (productMap.containsKey(p.id)) {
            System.out.println("❌ Error: Duplicate Product ID " + p.id + " rejected! Product: " + p.name);
            return false;
        }

        productMap.put(p.id, p);
        categoryMap.computeIfAbsent(p.category.toLowerCase(), k -> new ArrayList<>()).add(p);
        System.out.println("✅ Added: " + p.name + " (" + p.category + ")");
        return true;
    }

    // b) Quickly fetch all products by category
    public void getProductsByCategory(String category) {
        System.out.println("\n--- Products in Category: '" + category + "' ---");
        List<Product> list = categoryMap.get(category.toLowerCase());
        if (list == null || list.isEmpty()) {
            System.out.println("No products found in this category.");
        } else {
            for (Product p : list) {
                p.display();
            }
        }
    }

    // d) Display products sorted by stock quantity
    public void displaySortedByStock() {
        System.out.println("\n=== All Products Sorted by Stock Quantity (Ascending) ===");
        List<Product> list = new ArrayList<>(productMap.values());
        
        list.sort(Comparator.comparingInt(p -> p.stockQuantity));

        for (Product p : list) {
            p.display();
        }
    }

    public static void main(String[] args) {
        ProductCatalogSystem catalog = new ProductCatalogSystem();

        catalog.addProduct(new Product(101, "Laptop Pro", "Electronics", 15));
        catalog.addProduct(new Product(102, "Wireless Mouse", "Electronics", 80));
        catalog.addProduct(new Product(103, "Office Chair", "Furniture", 25));
        catalog.addProduct(new Product(104, "Standing Desk", "Furniture", 10));
        catalog.addProduct(new Product(105, "USB-C Hub", "Electronics", 45));
        
        // Attempting duplicate ID
        catalog.addProduct(new Product(101, "Duplicate Laptop", "Electronics", 5));

        // Fetch by category
        catalog.getProductsByCategory("Electronics");
        catalog.getProductsByCategory("Furniture");

        // Display sorted by stock
        catalog.displaySortedByStock();
    }
}

