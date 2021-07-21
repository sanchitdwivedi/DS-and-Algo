import java.util.ArrayList;

public class SerializeAdnDeserialize {
    static int index;
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	
    	ArrayList<Integer> arr=new ArrayList<>();
    	serialize(root,arr);
    	for (int x : arr) {
    	    System.out.print(x+" ");
    	}
    	System.out.println();
        index=0;
	    Node root_new=deSerialize(arr);
	    inorder(root_new);
    }

    public static void serialize(Node root, ArrayList<Integer> list){
        if(root==null){
            list.add(-1);
            return;
        }
        list.add(root.key);
        serialize(root.left, list);
        serialize(root.right, list);
    }

    public static Node deSerialize(ArrayList<Integer> list){
        if(index==list.size()) return null;
        int val = list.get(index);
        index++;
        if(val==-1) return null;
        Node root = new Node(val);
        root.left = deSerialize(list);
        root.right = deSerialize(list);
        return root;
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
}
