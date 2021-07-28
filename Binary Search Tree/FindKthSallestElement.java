/**
 * FindKthSallestElement
 */

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    int lCount;

    TreeNode(int x){
        data = x;
    }
}

public class FindKthSallestElement {
    public static void main(String[] args) {
        int arr[] = { 20, 8, 22, 4, 12, 10, 14 };
        int k = 4;
        // insert in BST
        TreeNode root=null;
        for(int i: arr){
            root = insert(root, i);
        }

        // find kth smallest element from BST
        TreeNode res = kthSmallest(root, k);
        if(res==null){
            System.out.println(-1);
        }
        else{
            System.out.println(res.data);
        }
    }

    public static TreeNode insert(TreeNode root, int i){
        if(root==null) return new TreeNode(i);
        if(root.data > i){
            root.left = insert(root.left, i);
            root.lCount++;
        }
        else if(root.data < i){
            root.right = insert(root.right, i);
        }
        return root;
    }   

    public static TreeNode kthSmallest(TreeNode root, int k){
        if(root==null) return null;
        int count = root.lCount + 1;
        if(count==k){
            return root;
        }
        else if(count > k){
            return kthSmallest(root.left, k);
        }
        else{
            return kthSmallest(root.right, k-count);
        }
    }
}