import java.util.ArrayDeque;

/**
 * InorderTraversal
 */

class Node{
    int key;
    Node left;
    Node right;
    Node(int k){
        key = k;
    }
}

public class InorderTraversal {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
    	inorder(root);
        System.out.println();
        inorderIterative(root);
    }

    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void inorderIterative(Node root){
        ArrayDeque<Node> s = new ArrayDeque<>();
        Node curr = root;
        while(curr!=null || !s.isEmpty()){
            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }
}