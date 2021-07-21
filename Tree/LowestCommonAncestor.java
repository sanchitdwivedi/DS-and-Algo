import java.util.ArrayList;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);

        int n1 = 20, n2 = 40;
        // Node ancestor = lca(root, n1, n2);
        Node ancestor = lcaEfficient(root, n1, n2);
        if(ancestor==null){
            System.out.println("No common ancestor found");
        }
        else{
            System.out.println(ancestor.key);
        }
    }

    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        if(findPath(root, n1, path1)==false || findPath(root, n2, path2)==false){
            return null;
        }
        Node ans = null;
        if(path1.get(0)==path2.get(0)){
            ans =  path1.get(0);
        }
        for(int i=0; i<path1.size()-1 && i<path2.size()-1; i++){
            if(path1.get(i+1)!=path2.get(i+1)){
                return path1.get(i);
            }
        }
        return ans;
    }

    public static boolean findPath(Node root, int n, ArrayList<Node> path){
        if(root==null) return false;
        path.add(root);
        if(root.key==n) return true;
        if(findPath(root.left, n, path) || findPath(root.right, n, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    // Assumption:- Both n1 and n2 are present in the tree
    public static Node lcaEfficient(Node root, int n1, int n2){
        if(root==null) return null;
        if(root.key==n1 || root.key==n2) return root;
        Node lca1 = lcaEfficient(root.left, n1, n2);
        Node lca2 = lcaEfficient(root.right, n1, n2);
        if(lca1!=null && lca2!=null){
            return root;
        }
        if(lca1!=null){
            return lca1;
        }
        else{
            return lca2;
        }
    }
}
