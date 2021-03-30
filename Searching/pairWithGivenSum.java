package Searching;

import java.io.*;

// Input is sorted array, Two pointer approach. If unsorted array is there then use hashing
public class pairWithGivenSum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = Integer.parseInt(br.readLine());
        System.out.println(pairExist(arr, n, sum));
    }
    
    public static String pairExist(int arr[], int n, int sum){
        int start = 0, end = n-1;
        while(start<=end){
            if(arr[start]+arr[end] == sum){
                return "Yes";
            }
            else if(arr[start]+arr[end] > sum){
                end = end-1;
            }
            else{
                start = start+1;
            }
        }
        return "No";
    }
}
