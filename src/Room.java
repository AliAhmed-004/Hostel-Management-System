class Room {
    int roomNumber;
    int studentCapacity;
    int studentsInRoom;
    Student next;
    Student prev;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.studentCapacity = 4;
        this.studentsInRoom = 0;
        this.next = this.prev = null;
    }

    Student head;

    // ADD STUDENT
    // <============================================
    public void addStudent(Student student) {
        if (head == null) {
            head = student;
            student.roomNumber = roomNumber;
            studentsInRoom++;
            return;
        }

        if (studentsInRoom < studentCapacity) {
            Student currentStudent = head;
            while (currentStudent.next != null) {
                currentStudent = currentStudent.next;
            }

            currentStudent.next = student;
            student.prev = currentStudent;
            student.roomNumber = roomNumber;
            studentsInRoom++;
        } else {
            new Room(roomNumber + 1).addStudent(student);
        }
    }

    // DELETE STUDENT METHOD
    // <============================================
    public void removeStudent(String name) {
        if (head == null) {
            System.out.println("Room is empty");
            return;
        }

        // deletion at start
        if (head.studentName.equals(name)) {
            head = head.next;
            head.prev = null;
            studentsInRoom--;
            return;
        }

        Student currentStudent = head;
        // deletion in middle
        while (currentStudent.next != null) {
            if (currentStudent.studentName.equals(name)) {
                currentStudent.prev.next = currentStudent.next;
                currentStudent.next.prev = currentStudent.prev;
                studentsInRoom--;
                return;
            }
            currentStudent = currentStudent.next;
        }

        // deletion at end
        currentStudent.prev.next = null;
        studentsInRoom--;
    }

    // CHECK STUDENTS IN ROOM
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

    // GET ROOM CAPACITY
    // <============================================
    public int getstudentCapacity() {
        return studentCapacity;
    }
}