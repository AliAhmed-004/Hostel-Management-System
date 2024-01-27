import java.util.Scanner;

public class AdminMenu {
    Scanner sc = new Scanner(System.in);
    private String username, password;

    public void displayMenu() throws InterruptedException {
        Admin admin = new Admin("Ali Ahmed", "1129141");

        System.out.print("Enter username: ");
        username = sc.nextLine();

        System.out.print("Enter Password: ");
        password = sc.nextLine();

        if(username.equals(admin.username) && password.equals(admin.password)) {
            System.out.println("Logging in, please wait");
            Thread.sleep(2000);
        } else {
            System.out.println("Invalid Username or Password");
        }
    }
}
