import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int arr[] = {30, 40, 10, 80, 5, 12, 70};
        bucketSort(arr, arr.length, 5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bucketSort(int arr[], int n, int k){
        int max_value = arr[0];
        for(int i=1; i<n; i++){
            max_value = Math.max(max_value, arr[i]);
        }
        max_value++;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for(int i=0; i<k; i++){
            bucket.add(new ArrayList<Integer>());
        }
        for(int i=0; i<n; i++){
            int bi = (k*arr[i])/max_value;
            bucket.get(bi).add(arr[i]);
        }
        for(int i=0; i<k; i++){
            Collections.sort(bucket.get(i));
        }
        int index=0;
        for(int i=0; i<k; i++){
            for(int j=0; j<bucket.get(i).size(); j++){
                arr[index] = bucket.get(i).get(j);
                index++;
            }
        }
    }
}
