import java.util.*;

class Pair{
    Node node;
    int hd;
    Pair(Node n, int h){
        node = n;
        hd = h;
    }
}

public class VerticalTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);  
        root.left = new Node(20);  
        root.right = new Node(30);  
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        vTraversal(root, map);

        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
            ArrayList<Integer> list = e.getValue();
            for(int i: list){
                System.out.print(i + " ");
            }
            System.out.println();

        }
    }

    public static void vTraversal(Node root, Map<Integer, ArrayList<Integer>> map){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int hd = p.hd;
            Node curr = p.node;
            if(map.containsKey(hd)){
                map.get(hd).add(curr.key);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.key);
                map.put(hd, list);
            }
            if(curr.left!=null) q.add(new Pair(curr.left, hd-1));
            if(curr.right!=null) q.add(new Pair(curr.right, hd+1));
        }
    }
}
