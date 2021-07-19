public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
    	System.out.println(height(root));
    }

    public static int height(Node root){
        if(root==null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
