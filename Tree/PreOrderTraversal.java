import java.util.ArrayDeque;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
    	preOrder(root);
        System.out.println();
        preorderIterative(root);
    }

    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void preorderIterative(Node root){
        if(root==null) return;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.key + " ");
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
        }
    }
}
