package Arrays;

import java.io.*;

// Check if there is a subarray whose sum is 'sum' ==> using sliding window
public class SubarrayWithRequiredSum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = Integer.parseInt(br.readLine());
        System.out.println(check(arr, n, sum));
    }

    public static boolean check(int arr[], int n, int sum) {
        int curr_sum = arr[0], start=0;
        for(int end=1; end<n; end++){
            while(curr_sum>sum && start<end-1){
                curr_sum -= arr[start];
                start++;
            }
            if(curr_sum==sum){
                return true;
            }
            if(end<n){
                curr_sum += arr[end];
            }
        }
        return (curr_sum==sum);
    }
}
