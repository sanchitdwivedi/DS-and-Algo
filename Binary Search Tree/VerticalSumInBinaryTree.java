import java.util.*;

public class VerticalSumInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);  
        root.left = new Node(20);  
        root.right = new Node(50);  
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        vSum(root, 0, map);
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            System.out.print(e.getValue() + " ");
        }
    }

    public static void vSum(Node root, int hd, TreeMap<Integer, Integer> map){
        if(root==null) return;
        vSum(root.left, hd-1, map);
        map.put(hd, map.getOrDefault(hd, 0) + root.key);
        vSum(root.right, hd+1, map);
    }
}
