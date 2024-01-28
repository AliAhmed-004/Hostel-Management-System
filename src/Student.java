public class Student {
    String studentName;
    String studentID;
    int roomNumber;
    Student next;
    Student prev;

    public Student(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.next = null;
    }
}
