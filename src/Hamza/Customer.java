package Hamza;

public class Customer {
    CusNode head = null;
    CusNode tail = null;

    public void placeOrder(String name, String contact, int bill, int orderNo) {
        CusNode newnode = new CusNode(name, contact, bill, orderNo);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = head.prev;
        }
    }

    public void submitOrder() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        
        System.out.println("Order No " + tail.orderNo + " Submited Successfully");
        tail = tail.prev;
        tail.next = null;
    }

    public void viewOrder() {
        if (head == null) {
            System.out.println("List is already Empty");
            return;
        }

        System.out.println("***************Orders***************");
        System.out.println("CUSTOMER NAME\t\tCONTACT NUMBER\t\tORDER NO\t\tBILL");
        CusNode s = tail;
        while (s.prev != null) {
            System.out.println(
                    s.name + "\t\t" + s.contact + "\t\t" + s.orderNo + "\t\t" + s.bill);
            s = s.prev;
        }
        System.out.println(
                s.name + "\t\t" + s.contact + "\t\t" + s.orderNo + "\t\t" + s.bill);
    }
}
