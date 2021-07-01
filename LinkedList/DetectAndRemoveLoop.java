public class DetectAndRemoveLoop {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = new Node(12);
        head.next = temp;
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        Node tail = new Node(25);
        head.next.next.next.next = tail;
        tail.next = temp;

        System.out.println(removeLoop(head));
    }

    public static boolean removeLoop(Node head){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return false; //No loop
        }
        slow = head;
        while(slow.next!=fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return true;
    }
}
