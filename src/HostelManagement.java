import java.util.Scanner;

public class HostelManagement {
    Scanner sc = new Scanner(System.in);
    public HostelManagement(){
        displayAdminMenu();
    }

    private void displayAdminMenu() {
        System.out.println("1. View Rooms");
        System.out.println("2. View Students");
        System.out.println("3. Exit\n");
        System.out.print("Enter Option: ");
        int op = sc.nextInt();
        sc.nextLine();

        choice(op);
    }

    private void choice(int choice) {
        switch (choice) {
            case 1:
                viewRooms();
                break;
        
            default:
                break;
        }
    }

    private void viewRooms() {
        
    }
}
