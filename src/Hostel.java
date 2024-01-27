public class Hostel {

    Room head;

    // GET ROOM DETAILS
    // <============================================
    public void getRoomDetails() {
        Room curr = head;

        while (curr != null) {
            System.out.println("Room Number: " + curr.roomNumber);
            System.out.println("Students in room: " + curr.studentsInRoom + "\n");
        }
    }
}