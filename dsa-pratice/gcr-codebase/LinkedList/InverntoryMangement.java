package LinkedList;

import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    float price;
    Item next;

    Item(String itemName, int itemId, int quantity, float price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    Item head = null;

    void addFirst(String name, int id, int qty, float price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    void addLast(String name, int id, int qty, float price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
        } else {
            Item curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newItem;
        }
    }

    void addAtPosition(int pos, String name, int id, int qty, float price) {
        if (pos == 0) {
            addFirst(name, id, qty, price);
            return;
        }

        Item curr = head;
        for (int i = 1; i < pos && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            Item newItem = new Item(name, id, qty, price);
            newItem.next = curr.next;
            curr.next = newItem;
        }
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item " + id + " removed.");
            return;
        }

        Item curr = head;
        while (curr.next != null && curr.next.itemId != id) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
            System.out.println("Item " + id + " removed.");
        } else {
            System.out.println("Item not found.");
        }
    }

    void updateQuantity(int id, int qty) {
        Item curr = head;
        while (curr != null) {
            if (curr.itemId == id) {
                curr.quantity = qty;
                System.out.println("Quantity updated.");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Item not found.");
    }

    void searchItem(String key) {
        boolean found = false;
        Item curr = head;
        while (curr != null) {
            if (String.valueOf(curr.itemId).equals(key) || curr.itemName.equalsIgnoreCase(key)) {
                System.out.println("Found: " + curr.itemName + " | ID: " + curr.itemId + " | Qty: " + curr.quantity + " | Price: " + curr.price);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    void totalInventoryValue() {
        float total = 0;
        Item curr = head;
        while (curr != null) {
            total += curr.quantity * curr.price;
            curr = curr.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    void sortByNameAsc() {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.itemName.compareToIgnoreCase(j.itemName) > 0) {
                    swap(i, j);
                }
            }
        }
        System.out.println("Sorted by Item Name (Ascending).");
    }

    void sortByPriceDesc() {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.price < j.price) {
                    swap(i, j);
                }
            }
        }
        System.out.println("Sorted by Price (Descending).");
    }

    void swap(Item a, Item b) {
        String tempName = a.itemName;
        int tempId = a.itemId;
        int tempQty = a.quantity;
        float tempPrice = a.price;

        a.itemName = b.itemName;
        a.itemId = b.itemId;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemName = tempName;
        b.itemId = tempId;
        b.quantity = tempQty;
        b.price = tempPrice;
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("\nInventory Items:");
        Item curr = head;
        while (curr != null) {
            System.out.println("Name: " + curr.itemName + ", ID: " + curr.itemId + ", Qty: " + curr.quantity + ", Price: ₹" + curr.price);
            curr = curr.next;
        }
    }
}

public class InverntoryMangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by Name or ID");
            System.out.println("7. Total Inventory Value");
            System.out.println("8. Sort by Name (ASC)");
            System.out.println("9. Sort by Price (DESC)");
            System.out.println("10. Display All Items");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            int id, qty, pos;
            float price;
            String name, key;

            switch (ch) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextFloat();
                    inv.addFirst(name, id, qty, price);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter ID in numbers: ");
                    id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextFloat();
                    inv.addLast(name, id, qty, price);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextFloat();
                    inv.addAtPosition(pos, name, id, qty, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    id = sc.nextInt();
                    inv.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Item ID to update: ");
                    id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    qty = sc.nextInt();
                    inv.updateQuantity(id, qty);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Enter Item Name or ID to Search: ");
                    key = sc.nextLine();
                    inv.searchItem(key);
                    break;

                case 7:
                    inv.totalInventoryValue();
                    break;

                case 8:
                    inv.sortByNameAsc();
                    break;

                case 9:
                    inv.sortByPriceDesc();
                    break;

                case 10:
                    inv.displayAll();
                    break;

                case 11:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
