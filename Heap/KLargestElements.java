import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int arr[] = {5, 15, 20, 10, 8, 25, 18};
        int k=3;

        kLargest(arr, arr.length, k);
    }

    public static void kLargest(int arr[], int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        for(int i=k; i<n; i++){
            if(arr[i]>=pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while(!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }
}
