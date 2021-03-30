package Searching;

import java.io.*;

/**
 * SearchingSortedRotatedArray
 */
public class SearchingSortedRotatedArray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(searchRecursive(arr, n, x, 0, n-1));
    }
    
    public static int searchRecursive(int arr[], int n, int x, int start, int end){
        int mid = (start+end)/2;
        if(start>end){
            return -1;
        }
        if(arr[mid]==x){
            return mid;
        }
        if(arr[start]<=arr[mid]){
            if(arr[start]<=x && arr[mid]>=x){
                return binarySearch(arr, start, mid, x);
            }
        }
        //return searchRecursive(arr, n, x, mid+1, end);
        return searchIterative(arr, n, x);
    }

    public static int binarySearch(int arr[], int start, int end, int x){
        int mid = (start+end)/2;
        while(start<=end){
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]<x){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static int searchIterative(int arr[], int n, int x){
        int start=0, end=n-1, mid;
        while(start<=end){
            mid=(start+end)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(arr[start]<=arr[mid]){
                if(arr[start]<=x && arr[mid]>=x){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(arr[mid+1]<=x && arr[end]>=x){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}