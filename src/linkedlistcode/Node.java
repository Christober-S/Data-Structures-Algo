package linkedlistcode;

public class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;

    void insertBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertLast(int data){
        if(head == null){
            insertBeginning(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void insertIndex (int index, int data){
        if (index < 0) {
            System.out.println("Invalid Index");
            return;
        }
        Node temp = head;
        for(int i = 0; i<index-1;i++){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next =  newNode;
    }

    void delete(int data){
        Node temp = head;
        if(head.data == data){
            head = head.next;
            return;
        }
        while (temp.next != null && temp.next.data != data){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("Invalid Index");
            return;
        }
        temp.next = temp.next.next;
    }

    void deleteIndex(int index){
        if(index < 0){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i<index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    void search(int data){
        Node temp = head;
        while (temp!=null){
            if(temp.data == data) {
                System.out.println(true);
                return;
            }
            temp = temp.next;
        }
        System.out.print(false);
    }

    void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    static void main() {
        LinkedList list = new LinkedList();
        list.insertBeginning(1);
        list.insertBeginning(2);
        list.insertBeginning(3);

        list.insertLast(4);

        list.insertIndex(2, 5);

        list.delete(5);

        list.deleteIndex(0);

        list.search(4);
        list.display();
    }
}