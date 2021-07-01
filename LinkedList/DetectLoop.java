/**
 * Floyd's cycle detection
 */
public class DetectLoop {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = new Node(12);
        head.next = temp;
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        Node tail = new Node(25);
        head.next.next.next.next = tail;
        tail.next = temp;

        System.out.println(detect(head));
    }

    public static boolean detect(Node head){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
