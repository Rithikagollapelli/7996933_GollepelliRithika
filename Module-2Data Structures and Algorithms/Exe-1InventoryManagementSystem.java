import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " " + productName + " Qty:" + quantity + " Price:" + price;
    }
}

public class Exe-1InventoryManagementSystem {
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    public static void updateProduct(int id, int qty) {
        if(inventory.containsKey(id))
            inventory.get(id).quantity = qty;
    }

    public static void deleteProduct(int id) {
        inventory.remove(id);
    }

    public static void display() {
        for(Product p : inventory.values())
            System.out.println(p);
    }

    public static void main(String[] args) {
        addProduct(new Product(1,"Laptop",10,50000));
        addProduct(new Product(2,"Mouse",50,500));

        updateProduct(1,15);
        deleteProduct(2);

        display();
    }
}