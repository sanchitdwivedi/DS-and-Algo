package Arrays;

import java.io.*;

/**
 * Kadane'sAlgo
 */
public class MaxSumSubarray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(maxSum(arr, n));
    }

    public static int maxSum(int[] arr, int n) {
        int res = arr[0];
        int maxEnding = arr[0];
        for(int i=1; i<n; i++){
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}