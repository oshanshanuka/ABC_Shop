package lk.ijse.abc;

import java.util.Scanner;

public class Customer {
    Scanner sc = new Scanner(System.in);
    String[][] customer = new String[1][4];


    public void manageCustomer() {

        System.out.println("\n\tManage Customer");
        System.out.println("\t------------");
        System.out.println();
        System.out.println("1. Add Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. View Customer");
        System.out.println("4. Delete Customer");
        System.out.println("5. Back");
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Main.clearScreen();
                addCustomer();
                break;
            case 2:
                Main.clearScreen();
                UpdateCustomer();
                break;
            case 3:
                Main.clearScreen();
                viewCustomerTable();
                break;
            case 4:
                Main.clearScreen();
                deleteCustomer();
            case 5:
                Main.clearScreen();
                Main.homePage();
                break;
            default:
                Main.clearScreen();
                System.out.println("Invalid choice. Please try again.");
                manageCustomer();
        }
    }

    private void deleteCustomer() {
        System.out.println("\n\tDelete Customer");
        System.out.println("\t------------");
        System.out.println();
        System.out.print("Enter Customer ID: ");
        String id = sc.next();
        System.out.println();
        if (searchCustomer(id)) {
            deleteCustomer();
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found.");
        }
        System.out.println("\nYou want to delete another customer? (y/n)");
        String choice = sc.next();
        if (choice.equals("y")) {
            Main.clearScreen();
            deleteCustomer();
        } else {
            Main.clearScreen();
            manageCustomer();
        }
    }

    private void UpdateCustomer() {
        System.out.println("\n\tUpdate Customer");
        System.out.println("\t------------");
        System.out.println();
        System.out.print("Enter Customer ID: ");
        String id = sc.next();
        System.out.println();
        if (searchCustomer(id)) {
            System.out.print("Enter new Customer Name: ");
            String name = sc.next();
            System.out.print("Enter new Customer Contact: ");
            String contact = sc.next();
            System.out.print("Enter new Customer Address: ");
            String address = sc.next();
            System.out.println();
            updateCustomer();
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
        System.out.println("\nYou want to update another customer? (y/n)");
        String choice = sc.next();
        if (choice.equals("y")) {
            Main.clearScreen();
            UpdateCustomer();
        } else {
            Main.clearScreen();
            manageCustomer();
        }
    }

    public static String[][] removeElement(String[][] oldArray, int index) {
        String[][] newArray = new String[oldArray.length - 1][4];
        for (int i = 0, k = 0; i < oldArray.length; i++) {
            if (i == index) {
                continue;
            }
            for (int j = 0; j < oldArray[i].length; j++) {
                newArray[k][j] = oldArray[i][j];
            }
            k++;
        }
        return newArray;
    }

    private void update(String[][] customer, int i) {
        System.out.println("\n\tUpdate Customer");
        System.out.println("\t---------------");
        System.out.print("Enter Name: ");
        customer[i][1] = sc.next();
        System.out.print("Enter Contact: ");
        customer[i][2] = sc.next();
        System.out.print("Enter Address: ");
        customer[i][3] = sc.next();
        System.out.println("Customer updated successfully.");
        manageCustomer();
    }

    private void delete(String[][] oldArray, int i) {
        customer = removeElement(oldArray, i);
        System.out.println("Customer deleted successfully.");
        updateCustomer();
    }

    private void updateCustomer() {

        boolean found = false;

        System.out.println("\n\tUpdate Customer");
        System.out.println("\t---------------");
        System.out.print("\nEnter Customer ID to update: ");
        String updateCID = sc.next();

        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] != null && customer[i][0].equals(updateCID)) {

                found = true;

                System.out.println("Current Name: " + customer[i][1]);

                System.out.println("Current Contact: " + customer[i][2]);

                System.out.println("Current Address: " + customer[i][3]);

                System.out.println("1. Update ?");
                System.out.println("2. Delete ?");
                System.out.println("3. Back");

                switch (sc.nextInt()) {
                    case 1:
                        Main.clearScreen();
                        update(customer, i);
                        break;
                    case 2:
                        Main.clearScreen();
                        delete(customer, i);
                        manageCustomer();
                        break;
                    case 3:
                        Main.clearScreen();
                        manageCustomer();
                        break;
                    default:
                        Main.clearScreen();
                        System.out.println("Invalid choice. Please try again.");
                        updateCustomer();
                }
            }
        }
        if (!found) {
            System.out.println("Customer ID not found.");
            manageCustomer();
        }
    }


    private boolean searchCustomer(String id) {
        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] == null) {
                continue;
            }
            if (customer[i][0].equals(id)) {
                return true;
            }
        }
        return false;
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

    private void viewCustomerTable() {
        System.out.printf("-------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-10s  |%-10s |%n", "C_id", "C_name", "C_contact", "C_address");
        System.out.printf("-------------------------------------------------------------------%n");

        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] == null) {
                continue;
            }
            System.out.printf("| %-10s | %-10s | %-10s  |%-10s |%n", customer[i][0], customer[i][1], customer[i][2], customer[i][3]);
        }
        System.out.printf("-------------------------------------------------------------------%n");
    }

    private void addCustomer() {
        System.out.println("\n\tAdd Customer");
        System.out.println("\t------------");
        System.out.println();
        System.out.print("C_id: ");
        String C_id = sc.next();
        if (searchCustomer(C_id)) {
            System.out.println("Customer ID already exists. Please try again.");
            addCustomer();

        }
        System.out.print("C_name: ");
        String C_name = sc.next();
        System.out.print("C_contact: ");
        String C_contact = sc.next();
        System.out.print("C_addrerss: ");
        String C_addres = sc.next();
        System.out.println();
        if (customer[customer.length - 1][0] != null) {
            customer = resizeArray(customer);
        }

        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] == null) {
                customer[i][0] = C_id;
                customer[i][1] = C_name;
                customer[i][2] = C_contact;
                customer[i][3] = C_addres;
            }
        }

        System.out.println("Customer added successfully.");
        System.out.println("\nYou want to add another customer? (y/n)");
        String choice = sc.next();
        if (choice.equals("y")) {
            Main.clearScreen();
            addCustomer();
        } else {
            Main.clearScreen();
            manageCustomer();
        }
    }
}
