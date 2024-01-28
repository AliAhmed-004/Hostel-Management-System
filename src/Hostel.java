import java.util.Scanner;

public class Hostel {
    private static Room[] rooms;

    public Hostel(int numberOfRooms) {
        initializeRooms(numberOfRooms);
    }

    // Initializing Rooms
    private void initializeRooms(int numberOfRooms) {
        rooms = new Room[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(4); // Each room has a capacity of 4 students
        }
    }

    // DISPLAY MENU METHOD
    // <============================================
    public void displayMenu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n\n1. Add Student to Room");
            System.out.println("2. Remove Student from Room");
            System.out.println("3. Check Full Rooms");
            System.out.println("4. Check Room Details");
            System.out.println("5. Number Of Rooms in the Hostel");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0;
            }

            switch (choice) {
                case 1:
                    addStudentToRoom();
                    break;
                case 2:
                    removeStudentFromRoom();
                    break;
                case 3:
                    checkFullRooms();
                    break;
                case 4:
                    printRoomDetails();
                    break;
                case 5:
                    printTotalRooms();
                    break;
                case 6:
                    System.out.println("Exiting Hostel Management, please wait....");
                    Thread.sleep(2000);
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
            }

        } while (choice != 6);
        
        scanner.close();
    }

    // ADD STUDENT TO ROOM
    // <============================================
    private void addStudentToRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();

        Student newStudent = new Student(studentName, studentID);

        // Find the first room with available space
        for (Room room : rooms) {
            if (!room.isRoomFull()) {
                room.addStudent(newStudent);
                System.out.println("\n" +studentName + " added to Room " + room.getRoomNumber() + "\n\n");
                return;
            }
        }

        // If all rooms are full, add the student to the next available room
        for (Room room : rooms) {
            if (room.getNextRoom() != null && !room.getNextRoom().isRoomFull()) {
                room.getNextRoom().addStudent(newStudent);
                System.out.println("\n" + studentName + " added to Room " + room.getNextRoom().getRoomNumber() + "\n");
                return;
            }
        }

        System.out.println("All rooms are full. Cannot add " + studentName + ".\n\n");
    }

    private void removeStudentFromRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name to remove: ");
        String studentName = scanner.nextLine();

        for (Room room : rooms) {
            if (room.searchStudent(studentName) != null) {
                room.removeStudent(room.searchStudent(studentName));
                System.out.println("\n" + studentName + " removed from Room " + room.getRoomNumber() + "\n\n");
                return;
            }
        }

        System.out.println("\nStudent \"" + studentName + "\" not found in any room.\n\n");
    }

    private void checkFullRooms() {
        System.out.println("\nRooms that are full:");
        for (Room room : rooms) {
            if (room.isRoomFull()) {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
    }

    private void printRoomDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nEnter room number to get details: ");
        int roomNumber = scanner.nextInt();

        if (roomNumber >= 1 && roomNumber <= rooms.length) {
            Room roomToPrint = rooms[roomNumber - 1];
            roomToPrint.printRoomDetails();
        } else {
            System.out.println("\nInvalid room number. Please enter a valid room number.\n\n");
        }
    }

    private void printTotalRooms() {
        System.out.println("\nTotal number of rooms in the hostel: " + rooms.length + "\n\n");
    }
}
