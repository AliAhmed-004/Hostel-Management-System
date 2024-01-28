import java.util.Scanner;

public class Hostel {
    private static Room[] rooms;

    public Hostel(int numberOfRooms) {
        initializeRooms(numberOfRooms);
    }

    private void initializeRooms(int numberOfRooms) {
        rooms = new Room[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(4); // Assuming each room has a capacity of 4 students
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHostel Management System - Admin Menu");
            System.out.println("1. Add Student to Room");
            System.out.println("2. Remove Student from Room");
            System.out.println("3. Check which Rooms are Full");
            System.out.println("4. Exit");
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
                    System.out.println("Exiting Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
            }

        } while (choice != 4);
        
        scanner.close();
    }

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
                System.out.println(studentName + " added to Room " + room.getRoomNumber());
                return;
            }
        }

        // If all rooms are full, add the student to the next available room
        for (Room room : rooms) {
            if (room.getNextRoom() != null && !room.getNextRoom().isRoomFull()) {
                room.getNextRoom().addStudent(newStudent);
                System.out.println(studentName + " added to Room " + room.getNextRoom().getRoomNumber());
                return;
            }
        }

        System.out.println("All rooms are full. Cannot add " + studentName + ".");
    }

    private void removeStudentFromRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name to remove: ");
        String studentName = scanner.nextLine();

        for (Room room : rooms) {
            if (room.searchStudent(studentName) != null) {
                room.removeStudent(room.searchStudent(studentName));
                System.out.println(studentName + " removed from Room " + room.getRoomNumber());
                return;
            }
        }

        System.out.println("Student " + studentName + " not found in any room.");
    }

    private void checkFullRooms() {
        System.out.println("Rooms that are full:");
        for (Room room : rooms) {
            if (room.isRoomFull()) {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
    }
}
