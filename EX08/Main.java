import java.util.*;

// Product Interface
interface Product {
    void displayDetails();
}

// LegacyItem Class
class LegacyItem {
    private int itemId;
    private String description;

    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}

// Adapter Class
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public void displayDetails() {
        legacyItem.print();
    }
}

// NewProduct Class
class NewProduct implements Product {
    private String name;

    public NewProduct(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("New Product -> Name: " + name);
    }
}

// Singleton InventoryManager
class InventoryManager {
    private static InventoryManager instance;
    private List<Product> productList;

    private InventoryManager() {
        productList = new ArrayList<>();
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Iterator<Product> returnInventory() {
        return productList.iterator();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        InventoryManager manager = InventoryManager.getInstance();

        // Adding new products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Mobile"));

        // Adding legacy products using adapter
        LegacyItem item1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem item2 = new LegacyItem(102, "Old Monitor");

        manager.addProduct(new ProductAdapter(item1));
        manager.addProduct(new ProductAdapter(item2));

        // Iterating using Iterator
        Iterator<Product> iterator = manager.returnInventory();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.displayDetails();
        }
    }
}