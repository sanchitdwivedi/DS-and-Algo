import java.util.HashMap;

public class BinaryTreeFromInorderPostorder {
    static int preIndex=0;
    static HashMap<Integer, Integer> map = new HashMap<>(); //use hashmap if items are distict
    public static void main(String[] args) {
        int in[] = {20, 10, 40, 30, 50};
        int pre[] = {10, 20, 30, 40, 50};
        for(int i=0; i<in.length; i++){
            map.put(in[i], i);
        }
        Node root = cTree(in, pre, 0, in.length-1);
        traverseTree(root);
    }

    public static Node cTree(int[] in, int[] pre, int start, int end){
        if(start>end) return null;
        Node root = new Node(pre[preIndex++]);
        /*
        int inIndex=start;
        for(int i=start; i<=end; i++){
            if(in[i]==root.key){
                inIndex = i;
                break;
            }
        }
        root.left = cTree(in, pre, start, inIndex-1);
        root.right = cTree(in, pre, inIndex+1, end);
        */
        root.left = cTree(in, pre, start, map.get(root.key)-1);
        root.right = cTree(in, pre, map.get(root.key)+1, end);
        return root;
    }

    public static void traverseTree(Node root){
        if(root==null) return;
        traverseTree(root.left);
        System.out.print(root.key + " ");
        traverseTree(root.right);
    }
}
