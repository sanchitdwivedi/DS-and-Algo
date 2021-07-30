import java.util.*;

public class BottomViewBT {
    public static void main(String[] args) {
        Node root = new Node(10);  
        root.left = new Node(20);  
        root.right = new Node(30);  
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        topView(root, 0, map);
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            System.out.print(e.getValue() + " ");
        }
    }

    public static void topView(Node root, int hd, TreeMap<Integer, Integer> map){
        if(root==null) return;
        topView(root.left, hd-1, map);
        if(!map.containsKey(hd)){
            map.put(hd, root.key);
        }
        topView(root.right, hd+1, map);
    }
}
