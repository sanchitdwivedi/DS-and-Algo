public class PreOrderTraversal {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
    	preOrder(root);
    }

    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
