public class MaxInBinaryTree {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);

        System.out.println(getMax(root));
    }

    public static int getMax(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
    }
}
