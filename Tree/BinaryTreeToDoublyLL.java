public class BinaryTreeToDoublyLL {
    static Node prev = null;
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);

        Node head = convert(root);
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    public static Node convert(Node root){
        if(root==null) return root;
        Node head = convert(root.left);
        if(prev==null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
        return head;
    }
}
