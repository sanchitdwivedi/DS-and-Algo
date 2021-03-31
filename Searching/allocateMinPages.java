package Searching;

import java.io.*;

public class allocateMinPages {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        //System.out.println(findMin(arr, n, k));
        System.out.println(findMinEfficient(arr, n, k));
    }

    // Naive solution with exponential time complexity
    public static int findMin(int arr[], int n, int k) {
        if(k==1){
            return sum(arr, 0, n-1);
        }
        if(n==1){
            return arr[0];
        }
        int res=Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            res = Math.min(res, Math.max(findMin(arr, i, k-1), sum(arr, i, n-1)));
        }
        return res;
    }

    public static int sum(int arr[], int start, int end) {
        int res=0;
        for(int i=start; i<=end; i++){
            res += arr[i];
        }
        return res;
    }

    // Efficient solution
    public static int findMinEfficient(int arr[], int n, int k){
        int sum=0, max=0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int low=max, high=sum, mid=0, res=0;
        while(low<=high){
            mid = (low+high)/2;
            if(isFeasible(arr, mid, k, n)){
                high = mid-1;
                res = mid;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }

    public static boolean isFeasible(int arr[], int res, int k, int n) {
        int req=1, sum=0;
        for(int i=0; i<n; i++){
            if(sum+arr[i] <= res){
                sum += arr[i];
            }
            else{
                req++;
                sum = arr[i];
            }
        }
        return req<=k;
    }
}