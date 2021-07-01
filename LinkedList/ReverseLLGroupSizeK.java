public class ReverseLLGroupSizeK {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        int k = 3;

        head = reverseK(head, k);

        traverseLL(head);
    }

    public static void traverseLL(Node head) {
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static Node reverseK(Node head, int k){
        Node curr = head, prevFirst = null;
        boolean isFirstPass = true;
        while(curr!=null){
            Node first = curr, prev = null;
            int count=0;
            while(curr!=null && count<k){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(isFirstPass){
                head = prev;
                isFirstPass = false;
            }
            else{
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }
}
