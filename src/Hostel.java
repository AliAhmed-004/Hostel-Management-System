public class Hostel {

    int roomCapacity;
    Room next;

    public Hostel() {
        this.roomCapacity = 50;
        this.next = null;
    }
    Room head;

    // TRAVERSE ROOMS
    // <============================================
    public void traverseRooms() {
        if(head == null) {
            System.out.println("No Rooms");
            return;
        }

        Room currentRoom = head;

        while(currentRoom != null) {
            System.out.println(currentRoom.roomNumber);
            currentRoom = currentRoom.next;
        }
    }

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