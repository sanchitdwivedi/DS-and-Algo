package Recursion;

import java.io.*;

public class SubsetSum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = Integer.parseInt(br.readLine());
        System.out.println(subsetCount(arr, n, sum));
    }

    public static int subsetCount(int[] arr, int n, int sum){
        if(n==0){
            return ((sum==0) ? 1 : 0);
        }
        return subsetCount(arr, n-1, sum-arr[n-1]) + subsetCount(arr, n-1, sum);
    }
}
