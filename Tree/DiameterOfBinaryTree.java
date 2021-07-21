public class DiameterOfBinaryTree {
    static int dia;
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
        dia = 0;
    	height(root);
        System.out.println(dia);
    }

    public static int height(Node root){
        if(root==null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        dia = Math.max(dia, 1+lh+rh);
        return Math.max(lh, rh)+1;
    }
}
