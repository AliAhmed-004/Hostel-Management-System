package Hamza;

public class Employee {
    String username = "Ali Ahmed";
    String pswd = "5335";
    empnode head = null;
    empnode tail = null;

    public void insertItem(String name, int price, int code) {
        empnode newnode = new empnode(name, price, code);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = head.prev;
        }
    }

    public void deleteProduct(int code) {
        if (head == null) {
            System.out.println("List is already Empty");
        }

        else {
            empnode s = head.next;
            if (head.code == code) {
                head = head.next;
                head.prev = null;
            } else if (tail.code == code) {
                tail = tail.prev;
                tail.next = null;
            } else {
                while (s.next != null) {
                    if (s.code == code) {
                        s.prev.next = s.next;
                        s.next.prev = s.prev;
                    }
                    s = s.next;
                }
            }
        }
    }

    public int Search(int code) {
        if(head == null) {
            System.out.println("List is empty");
            return 0;
        }
        empnode s = head;
        while (s != null) {
            if (s.code == code) {
                return s.price;
            }
            s = s.next;
        }
        return 0;
    }

    public void menu() {
        System.out.println("***************MENU***************");
        System.out.println("ITEM NAME     ITEM PRICE    ITEMCODE");
        empnode s = tail;
        while (s.prev != null) {
            System.out.println(s.name + "         " + s.price + "           " + s.code);
            s = s.prev;
        }
        System.out.println(s.name + "         " + s.price + "           " + s.code);
    }

}
