import java.util.*;

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
