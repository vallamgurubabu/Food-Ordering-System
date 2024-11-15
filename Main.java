import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodOrderSystem system = new FoodOrderSystem();
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Food Ordering System!");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Order");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayMenu();
                    break;
                case 2:
                    System.out.print("Enter item ID to order: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    system.addOrder(itemId, quantity);
                    break;
                case 3:
                    system.displayOrder();
                    break;
                case 4:
                    system.checkout();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the system. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
