import java.util.*;

public class TreeSpiralTraversal {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
    	// spiralTraversal(root);
        spiralTraversalEfficient(root);
    }

    public static void spiralTraversal(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();

        boolean reverse = false;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                Node curr = q.remove();
                if(reverse){
                    s.push(curr);
                }
                else{
                    System.out.print(curr.key + " ");
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(reverse){
                while(!s.isEmpty()){
                    System.out.print(s.pop().key + " ");
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }

    public static void spiralTraversalEfficient(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node curr = s1.pop();
                System.out.print(curr.key + " ");
                if(curr.left!=null) s2.push(curr.left);
                if(curr.right!=null) s2.push(curr.right);
            }
            System.out.println();
            while(!s2.isEmpty()){
                Node curr = s2.pop();
                System.out.print(curr.key + " ");
                if(curr.right!=null) s1.push(curr.right);
                if(curr.left!=null) s1.push(curr.left);
            }
            System.out.println();
        }
    }
}
