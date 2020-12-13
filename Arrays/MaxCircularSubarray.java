package Arrays;

import java.io.*;

public class MaxCircularSubarray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(maxCircularSum(arr, n));
    }

    public static int maxCircularSum(int arr[], int n) {
        //Normal Sum
        int max_normal = kadane(arr, n);
        if(max_normal<0) return max_normal;
        //Circular Sum
        int arr_sum = 0;
        for(int i=0; i<n; i++){
            arr_sum += arr[i];
            arr[i] = -arr[i];
        }
        int max_circluar = arr_sum + kadane(arr, n);
        return Math.max(max_circluar, max_normal);
    }

    public static int kadane(int arr[], int n) {
        int res = arr[0];
        int maxEnding = arr[0];
        for(int i=1; i<n; i++){
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}
