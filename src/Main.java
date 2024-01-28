import java.util.Scanner;

import Hamza.CafeteriaMenu;
import Hamza.Customer;
import Hamza.Employee;
import Sharjeel.Admin;
import Sharjeel.DepartmentManagement;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("Ali Ahmed", "3553");

        boolean loginSuccessful = false;

        String username = "";
        String password = "";

        while (!loginSuccessful) {
            System.out.print("Enter Username: ");
            username = sc.nextLine();

            System.out.print("Enter Password: ");
            password = sc.nextLine();
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                loginSuccessful = true;
            } else {
                System.out.println("Wrong username or password! Please try again.");
            }
        }

        int choice;
        do {
            System.out.println("\n\n1. Department Management");
            System.out.println("2. Hostel Management");
            System.out.println("3. Cafeteria Management");
            System.out.println("4. Exit");
            System.out.print("\nEnter Option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n\nOpening Department Management");
                    Thread.sleep(1000);
                    new DepartmentManagement().menuDepartment();;
                    break;
                
                case 2:
                    // Hostel Management
                    System.out.println("\n\nOpening Hostel Management");
                    Thread.sleep(1000);
                    new Hostel(20).displayMenu();
                    break;
                
                case 3:
                    // Cafeteria Management
                    System.out.println("\n\nOpening Cafeteria Management");
                    Thread.sleep(1000);
                    new CafeteriaMenu().mainMenu(new Employee(), new Customer(), new CafeteriaMenu());
                    break;
                case 4:
                    System.out.print("\n\nExiting. Thank you for using the UMS");
                    Thread.sleep(2000);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
