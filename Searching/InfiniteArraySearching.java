package Searching;

import java.io.*;

public class InfiniteArraySearching {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(search(arr, x));
    }

    public static int search(int arr[], int x){    
        if(arr[0]==x){
            return 0;
        }
        int pointer=1;
        while(arr[pointer] < x){
            pointer *= 2;
        }
        if(arr[pointer]==x){
            return pointer;
        }
        return binarySearch(arr, x, pointer/2 + 1, pointer-1);
    }

    public static int binarySearch(int arr[], int x, int start, int end){
        int mid = (start+end)/2;
        while(start<=end){
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]>x){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }

}   
