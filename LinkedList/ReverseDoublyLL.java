/**
 * ReverseDoublyLL
 */
class Node{
    int data;
    Node next;
    Node prev;
    public Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

public class ReverseDoublyLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        traverseDLL(head);
        System.out.println();
        traverseDLL(reverseDLL(head));
    }

    public static void traverseDLL(Node head) {
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static Node reverseDLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        return prev.prev;
    }
}