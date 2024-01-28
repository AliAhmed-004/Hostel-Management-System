package Hamza;

public class CusNode {
    String name;
    String contact;
    int bill;
    int orderNo;
    CusNode next;
    CusNode prev;
    public CusNode(String name, String contact, int bill,int orderNo) {
        this.name = name;
        this.contact = contact;
        this.bill = bill;
        this.orderNo = orderNo;
        this.next = null;
        this.prev = null;
    }
}
