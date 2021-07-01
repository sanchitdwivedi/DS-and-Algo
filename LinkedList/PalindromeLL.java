public class PalindromeLL {
    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(0);
        a.next.next = new Node(0);
        a.next.next.next = new Node(1);

        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(Node a){
        if(a==null) return true;
        Node slow = a, fast = a;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node rev = reverseLL(slow);
        for(Node i=a; i!=null; i = i.next){
            System.out.print(i.data + " ");
        }
        Node curr = a;
        while(rev!=null){
            if(rev.data != curr.data){
                return false;
            }
            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }

    public static Node reverseLL(Node mid){
        Node prev=null, curr=mid.next, next=null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = prev;
        return prev;
    }
}
