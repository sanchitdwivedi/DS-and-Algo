public class FixBSTWith2NodesSwapped {
    static Node prev=null, first=null, second=null;
    public static void main(String[] args) {
        Node root = new Node(18);  
        root.left = new Node(60);  
        root.right = new Node(70);  
        root.left.left = new Node(4);  
        root.right.left = new Node(8);
        root.right.right = new Node(80); 

        fixBST(root);
        
        if(first!=null && second!=null){
            int temp = first.key;
            first.key = second.key;
            second.key = temp;

            inorder(root);
        }
        else{
            System.out.println("Nothing wrong");
        }
    }

    public static void fixBST(Node root){
        if(root==null) return;
        fixBST(root.left);
        if(prev!=null && root.key < prev.key){
            if(first==null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        fixBST(root.right);
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
}
