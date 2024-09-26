package lk.ijse.abc;
import java.util.Scanner;
public class Order {
    Scanner sc = new Scanner(System.in);
    String[][] order = new String[1][5];

    public void manageOrder() {

        System.out.println("\n\tManage Order");
        System.out.println("\t------------");
        System.out.println();
        System.out.println("1. Add Order");
        System.out.println("2. View Order");
        System.out.println("3. Back");
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Main.clearScreen();
                addOrder();
                break;
            case 2:
                Main.clearScreen();
                viewOrderTable();
                break;
            case 3:
                Main.clearScreen();
                Main.homePage();
                break;
            default:
                Main.clearScreen();
                System.out.println("Invalid choice. Please try again.");
                manageOrder();
        }
    }
    private String[][] resizeArray(String[][] oldArray) {
        String[][] newArray = new String[oldArray.length + 1][4];
        for (int i = 0; i < oldArray.length; i++) {
            for (int j = 0; j < oldArray[i].length; j++) {
                newArray[i][j] = oldArray[i][j];
            }
        }
        return newArray;
    }
    private void viewOrderTable() {
        System.out.printf("-------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-10s  |%-10s |%n","C_id", "C_name","C_contact", "C_address");
        System.out.printf("-------------------------------------------------------------------%n");

        for (int i = 0; i < order.length; i++) {
            if (order[i][0] == null) {
                continue;
            }
            System.out.printf("| %-10s | %-10s | %-10s  |%-10s |%n",order[i][0], order[i][1],order[i][2],order[i][3]);
        }
        System.out.printf("-------------------------------------------------------------------%n");
    }

    private void addOrder() {
        System.out.println("\n\tAdd Order");
        System.out.println("\t------------");
        System.out.println();
        System.out.print("OID: ");
        String oid = sc.next();
        for (int i = 0; i < order.length; i++) {
            if (order[i][0] != null && order[i][0].equals(oid)) {
                System.out.println("Order ID already exists. Please enter a different ID.");
                addOrder();
            }

        }
        System.out.print("CID: ");
        String cid = sc.next();
        System.out.print("Order Number: ");
        String OrdNum = sc.next();
        System.out.print("Quantity: ");
        String qty = sc.next();
        System.out.print("Price: ");
        String price = sc.next();
        System.out.println();
        if (order[order.length - 1][0] != null) {
            order = resizeArray(order);
        }

        for (int i = 0; i < order.length; i++) {
            if (order[i][0] == null) {
                order[i][0] = oid;
                order[i][1] = cid;
                order[i][2] = OrdNum;
                order[i][3] = qty;
                order[i][4] = price;
                break;
            }
        }

        System.out.println("Order added successfully.");
        System.out.println("\nYou want to add another order? (y/n)");
        String choice = sc.next();
        if (choice.equals("y")) {
            Main.clearScreen();
            addOrder();
        } else {
            Main.clearScreen();
            manageOrder();
        }
    }
}