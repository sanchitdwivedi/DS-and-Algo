package Arrays;

import java.io.*;

public class MaxEvenOddSubarray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(maxEvenOdd(arr, n));
    }

    public static int maxEvenOdd(int arr[], int n) {
        int res = 1;
        int curr = 1;
        for(int i=1; i<n; i++){
            if((arr[i]%2==0 && arr[i-1]%2 != 0) || (arr[i]%2!=0 && arr[i-1]%2 == 0)){
                curr++;
                res = Math.max(res, curr);
            }
            else curr = 1;
        }
        return res;
    }
}
