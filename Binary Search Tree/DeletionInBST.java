/**
 * DeletionInBST
 */
class Node  
{ 
  int key; 
  Node left; 
  Node right; 
  Node(int k){
      key=k;
      left=right=null;
  }
}

public class DeletionInBST {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(5);
    	root.right=new Node(15);
    	root.right.left=new Node(12);
    	root.right.right=new Node(18);
    	int x=15;
    	
    	root=delNode(root,x);
	    inorder(root);
    }

    public static Node delNode(Node root, int x){
        if(root==null) return root;
        if(root.key<x){
            root.right = delNode(root.right, x);
        }
        else if(root.key>x){
            root.left = delNode(root.left, x);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node succ = getSucc(root);
            root.key = succ.key;
            root.right = delNode(root.right, succ.key);
        }
        return root;
    }

    public static Node getSucc(Node root){
        Node curr = root.right;
        while(curr!=null && curr.left!=null){
            curr = curr.left;
        }
        return curr;
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
}