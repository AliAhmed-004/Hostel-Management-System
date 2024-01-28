class Room {
    

    private static int roomCounter = 1;
    private final int roomNumber;
    private final int studentCapacity;
    private Student head;

    public Room(int studentCapacity) {
        this.roomNumber = roomCounter++;
        this.studentCapacity = studentCapacity;
        this.head = null;
    }

    // ADD STUDENT METHOD
    // <============================================
    public void addStudent(Student student) {
        if (head == null) {
            head = student;
            student.roomNumber = roomNumber;
            return;
        }

        if (getNumberOfStudents() < studentCapacity) {
            Student currentStudent = head;
            while (currentStudent.next != null) {
                currentStudent = currentStudent.next;
            }

            currentStudent.next = student;
            student.prev = currentStudent;
            student.roomNumber = roomNumber;
        } else {
            new Room(studentCapacity).addStudent(student);
        }
    }

    // REMOVE STUDENT
    // <============================================
    public void removeStudent(Student student) {
        if (head == null) {
            System.out.println("Room is empty");
            return;
        }

        // Deletion at start
        if (head.studentName.equals(student.studentName)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        // Deletion in between
        Student currentStudent = head;

        while (currentStudent != null) {
            if (currentStudent.studentName.equals(student.studentName)) {
                if (currentStudent.next == null) {
                    // If the student to be removed is the last node
                    currentStudent.prev.next = null;
                } else {
                    currentStudent.next.prev = currentStudent.prev;
                    currentStudent.prev.next = currentStudent.next;
                }
                return;
            }
            currentStudent = currentStudent.next;
        }
    }

    // SEARCH FOR A STUDENT
    // <============================================
    public Student searchStudent(String studentName) {
        Student currentStudent = head;
        while (currentStudent != null) {
            if (currentStudent.studentName.equals(studentName)) {
                return currentStudent;
            }
            currentStudent = currentStudent.next;
        }
        return null; // Student not found
    }

    // GET THE NUMBER OF STUDENTS
    // <============================================
    public int getNumberOfStudents() {
        int count = 0;
        Student currentStudent = head;
        while (currentStudent != null) {
            count++;
            currentStudent = currentStudent.next;
        }
        return count;
    }

    // CLEAR ALL STUDENTS
    // <============================================
    public void clearStudents() {
        head = null;
    }

    // PRINT ROOM DETAILS
    // <============================================
    public void printRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Capacity: " + studentCapacity);
        System.out.println("Number of Students: " + getNumberOfStudents());
        System.out.println("Students in Room:");
        traverseStudents();
    }

    // CHECK IF THE ROOM IS FULL
    // <============================================
    public boolean isRoomFull() {
        return getNumberOfStudents() >= studentCapacity;
    }

    // TRAVERSE STUDENTS IN ROOM
    // <============================================
    public void traverseStudents() {
        if (head == null) {
            System.out.println("Room is Empty");
            return;
        }

        int i = 1;
        Student currentStudent = head;
        while (currentStudent != null) {
            System.out.println("Student " + i + ": " + currentStudent.studentName);
            currentStudent = currentStudent.next;
            i++;
        }
    }

    // GET ROOM NUMBER
    // <============================================
    public int getRoomNumber() {
        return roomNumber;
    }

    // GET NEXT ROOM
    // <============================================
    public Room getNextRoom() {
        if (roomNumber < roomCounter) {
            return new Room(studentCapacity);
        }
        return null;
    }
}
