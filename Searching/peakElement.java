package Searching;

import java.io.*;

// Input is unsorted array, Peak element --> element greater than its previous and after element
public class peakElement {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findPeak(arr, n));
    }

    public static int findPeak(int arr[], int n){
        int start=0, end=n-1, mid;
        while(start<=end){
            mid = (start+end)/2;
            if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==n-1 || arr[mid+1]<=arr[mid])){
                return mid;
            }
            if(mid>0 && arr[mid-1]>arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
