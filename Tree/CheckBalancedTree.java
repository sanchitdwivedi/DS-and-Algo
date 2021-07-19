public class CheckBalancedTree {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
    	if(isBalanced(root)==-1){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }
    }

    public static int isBalanced(Node root){
        if(root==null) return 0;
        int lh = isBalanced(root.left);
        if(lh==-1) return -1;
        int rh = isBalanced(root.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return 1+Math.max(lh, rh);
    }
}
