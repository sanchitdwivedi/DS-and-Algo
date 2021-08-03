import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 19, 18};
        int k = 2;
        sortK(arr, arr.length, k);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // Time complexity => O(k*log(k))
    public static void sortK(int[] arr, int n, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<=k; i++){
            q.add(arr[i]);
        }
        int index=0;
        for(int i=k+1; i<n; i++){
            arr[index] = q.remove();
            index++;
            q.add(arr[i]);
        }
        while(!q.isEmpty()){
            arr[index] = q.remove();
            index++;
        }
    }
}
