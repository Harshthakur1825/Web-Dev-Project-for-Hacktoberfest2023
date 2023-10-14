import java.util.Scanner;

public class HostelMessManagement {
    private static String[] menu;
    private static double[] prices;
    private static int[] quantities;

    public HostelMessManagement(int capacity) {
        menu = new String[capacity];
        prices = new double[capacity];
        quantities = new int[capacity];
    }

    public void addMenuItem(String item, double price) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == null) {
                menu[i] = item;
                prices[i] = price;
                quantities[i] = 0;
                System.out.println("Item added to the menu: " + item);
                return;
            }
        }
        System.out.println("Menu is full. Cannot add more items.");
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.println(i + ". " + menu[i] + " - $" + prices[i]);
            }
        }
    }

    public void placeOrder(int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < menu.length && menu[itemIndex] != null) {
            quantities[itemIndex] += quantity;
            System.out.println("Order placed: " + menu[itemIndex] + " x " + quantity);
        } else {
            System.out.println("Invalid menu item.");
        }
    }

    public double calculateBill() {
        double totalBill = 0.0;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                totalBill += prices[i] * quantities[i];
            }
        }
        return totalBill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of menu items: ");
        int capacity = scanner.nextInt();
        HostelMessManagement messManager = new HostelMessManagement(capacity);

        while (true) {
            System.out.println("\nHostel Mess Food Management System");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Display Menu");
            System.out.println("3. Place Order");
            System.out.println("4. Calculate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    scanner.nextLine();
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: $");
                    double itemPrice = scanner.nextDouble();
                    messManager.addMenuItem(itemName, itemPrice);
                    break;
                case 2:
                    messManager.displayMenu();
                    break;
                case 3:
                    System.out.print("Enter the item number: ");
                    int itemNumber = scanner.nextInt();
                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    messManager.placeOrder(itemNumber, quantity);
                    break;
                case 4:
                    double totalBill = messManager.calculateBill();
                    System.out.println("Total Bill: $" + totalBill);
                    break;
                case 5:
                    System.out.println("Exiting Hostel Mess Food Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
