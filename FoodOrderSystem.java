import java.util.*;

class FoodOrderSystem {
    private List<FoodItem> menu;
    private Map<FoodItem, Integer> order;

    public FoodOrderSystem() {
        menu = new ArrayList<>();
        order = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        menu.add(new FoodItem(1, "Burger", 5.99));
        menu.add(new FoodItem(2, "Pizza", 8.99));
        menu.add(new FoodItem(3, "Pasta", 7.49));
        menu.add(new FoodItem(4, "Fries", 2.99));
        menu.add(new FoodItem(5, "Soda", 1.99));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (FoodItem item : menu) {
            System.out.println(item);
        }
    }

    public void addOrder(int itemId, int quantity) {
        for (FoodItem item : menu) {
            if (item.getId() == itemId) {
                order.put(item, order.getOrDefault(item, 0) + quantity);
                System.out.println(quantity + "x " + item.getName() + " added to the order.");
                return;
            }
        }
        System.out.println("Invalid item ID. Please try again.");
    }

    public void displayOrder() {
        System.out.println("\nYour Order:");
        if (order.isEmpty()) {
            System.out.println("No items ordered yet.");
        } else {
            double total = 0.0;
            for (Map.Entry<FoodItem, Integer> entry : order.entrySet()) {
                FoodItem item = entry.getKey();
                int quantity = entry.getValue();
                double cost = item.getPrice() * quantity;
                total += cost;
                System.out.println(quantity + "x " + item.getName() + " - $" + cost);
            }
            System.out.println("Total: $" + total);
        }
    }

    public void checkout() {
        if (order.isEmpty()) {
            System.out.println("No items to checkout.");
        } else {
            displayOrder();
            System.out.println("\nThank you for your order! Please proceed to payment.");
            order.clear();
        }
    }
}