public class Main {
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room(1);
        room.addStudent(new Student("Sharjeel", "F22BSCS016"));
        room.addStudent(new Student("Wajahat", "F22BSCS036"));
        room.addStudent(new Student("Ali Ahmed", "F22BSCS046"));
        room.addStudent(new Student("Hamza", "F22BSCS048"));
        room.addStudent(new Student("Hamza", "F22BSCS048"));

        room.traverseStudents();
    }
}
