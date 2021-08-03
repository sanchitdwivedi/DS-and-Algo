import java.util.*;

public class MedianOfStream {
    public static void main(String[] args) {
        int arr[] = { 12, 15, 10, 5, 8, 7, 16};
    
        printMedians(arr, arr.length);
    }

    public static void printMedians(int arr[], int n){
        PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> g = new PriorityQueue<>();

        s.add(arr[0]);
        System.out.print(arr[0] + " ");

        for(int i=1; i<n; i++){
            if(s.size() > g.size()){
                if(s.peek() > arr[i]){
                    g.add(s.remove());
                    s.add(arr[i]);
                }
                else{
                    g.add(arr[i]);
                }
                System.out.print((s.peek()+g.peek())/2.0 + " ");
            }
            else{
                if(s.peek() >= arr[i]){
                    s.add(arr[i]);
                }
                else{
                    g.add(arr[i]);
                    s.add(g.remove());
                }
                System.out.print(s.peek() + " ");
            }
        }
    }
}
