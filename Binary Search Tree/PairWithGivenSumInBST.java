import java.util.HashSet;

public class PairWithGivenSumInBST {
    public static void main(String[] args) {
        Node root = new Node(10);  
        root.left = new Node(8);  
        root.right = new Node(20);  
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);  
        root.right.right.left = new Node(25);
        
        int sum=33;

        HashSet<Integer> set = new HashSet<>();
        System.out.println(isPresent(root, sum, set));
    }

    public static boolean isPresent(Node root, int sum, HashSet<Integer> set){
        if(root==null) return false;
        if(isPresent(root.left, sum, set)) return true;
        if(set.contains(sum - root.key)) return true;
        else set.add(root.key);
        return isPresent(root.right, sum, set);
    }
}
