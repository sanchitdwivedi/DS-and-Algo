package Arrays;

import java.io.*;

// Find maximum sum of a subarray of size 'k' in the array
public class SlidingWindow {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        System.out.println(maxSum(arr, n, k));
    }

    public static int maxSum(int arr[], int n, int k) {
        int curr_sum=0;
        int max_sum;
        for(int i=0; i<k; i++){
            curr_sum += arr[i];
        }
        max_sum = curr_sum;
        for(int i=k; i<n; i++){
            curr_sum += arr[i] - arr[i-k];
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }
}
