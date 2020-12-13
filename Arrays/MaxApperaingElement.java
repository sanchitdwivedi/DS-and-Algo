package Arrays;

import java.io.*;

/**
 * Given two arrays denoting the ranges L[] ==> start value of range 
 * R[] ==> End value of range
 * 
 * 0 <= L[i], R[i] <= 1000
 * 
 * Calculate the element which is appearing in maximum ranges ====> Prefix sum
 */
public class MaxApperaingElement {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int L[] = new int[n];
        for(int i=0; i<n; i++){
            L[i] = Integer.parseInt(br.readLine());
        }

        int R[] = new int[n];
        for(int i=0; i<n; i++){
            R[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(maxOcc(L, R, n));
    }

    public static int maxOcc(int L[], int R[], int n) {
        int arr[] = new int[1000];
        for(int i=0; i<n; i++){
            arr[L[i]]++;
            arr[R[i]+1]--;
        }
        int max = arr[0];
        int res = 0;
        for(int i=1; i<1000; i++){
            arr[i] += arr[i-1];
            if(max<arr[i]){
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
}
