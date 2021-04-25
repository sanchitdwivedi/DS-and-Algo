import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {5, 6, 5, 2, 1, 0, 0, 2};
        // naiveCountingSort(arr, arr.length, 7);
        countingSort(arr, arr.length, 7);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    // Suitable for primitive data types
    public static void naiveCountingSort(int arr[], int n, int k){
        int count[] = new int[k];
        Arrays.fill(count, 0);
        for(int i=0; i<n; i++){
            count[arr[i]]++;
        }
        int index=0;
        for(int i=0; i<k; i++){
            if(count[i] == 0){
                continue;
            }
            for(int j=0; j<count[i]; j++){
                arr[index] = i;
                index++;
            }   
        }
    }

    // Suitable for Objects also
    public static void countingSort(int arr[], int n, int k){
        int count[] = new int[k];
        int output[] = new int[n];
        Arrays.fill(count, 0);
        for(int i=0; i<n; i++){
            count[arr[i]]++;
        }
        for(int i=1; i<k; i++){
            count[i] = count[i-1] + count[i];
        }
        for(int i=n-1; i>=0; i--){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for(int i=0; i<n; i++){
            arr[i] = output[i];
        }
    }
}
