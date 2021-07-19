import java.util.*;

public class LevelOrderTraversalLineByLine {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);

        // printLevelLine(root);
        printLevelLine2(root);
    }

    public static void printLevelLine(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size()>1){
            Node curr = q.remove();
            if(curr==null){
                System.out.println();
                q.add(null);
            }
            else{
                System.out.print(curr.key + " ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }

    // Method 2
    public static void printLevelLine2(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0; i<count; i++){
                Node curr = q.remove();
                System.out.print(curr.key + " ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            System.out.println();
        }
    }
}
