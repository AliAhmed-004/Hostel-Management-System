package Hamza;

public class empnode {
    String name;
    int price;   
    int code;
    empnode next;
    empnode prev;
    public empnode(String name, int price, int code) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.next = null;
        this.prev = null;
    }
}
