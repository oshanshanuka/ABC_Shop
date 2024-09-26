package lk.ijse.abc;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void homePage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("Welcome to ABC Shop");
        System.out.println("=====================================");

        System.out.println("1.Manage Customer");
        System.out.println("2.Manage Orders");
        System.out.println("3.Exit");
        System.out.println();

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        clearScreen();
        switch (choice){
            case 1:
                Customer customer = new Customer();
                clearScreen();
                customer.manageCustomer();
                break;
            case 2:
                Order order = new Order();
                clearScreen();
                order.manageOrder();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                clearScreen();
                System.out.println("Invalid Input");
                homePage();
        }


    }
    public static void main(String[] args) {
        homePage();
    }

}