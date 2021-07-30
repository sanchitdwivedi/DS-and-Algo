public class CheckIfBST {
    public static void main(String[] args) {
        Node root = new Node(4);  
        root.left = new Node(2);  
        root.right = new Node(5);  
        root.left.left = new Node(1);  
        root.left.right = new Node(3);  

        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }

    public static boolean isBST(Node root, int min, int max){
        if(root==null) return true;
        if(root.key < max && root.key > min && isBST(root.left, min, root.key) && isBST(root.right, root.key, max)){
            return true;
        }
        else{
            return false;
        }
    }
}
