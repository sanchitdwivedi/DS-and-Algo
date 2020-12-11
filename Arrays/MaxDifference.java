package Arrays;

import java.io.*;

/**
 * MaxDifference
 */
public class MaxDifference {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(maxDiff(arr, n));
    }

    public static int maxDiff(int[] arr, int n){
        int res = arr[1]-arr[0];
        int minValue = arr[0];
        for(int i=1; i<n; i++){
            res = Math.max(res, arr[i]-minValue);
            minValue = Math.min(minValue, arr[i]);
        }
        return res;
    }
}