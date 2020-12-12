package Arrays;

import java.io.*;

/**
 * RainWaterTrapping
 */
public class RainWaterTrapping {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(trappedWater(arr, n));
    }

    public static int trappedWater(int[] arr, int n) {
        int res = 0;
        int lmax[] = new int[n];
        int rmax[] = new int[n];
        lmax[0] = arr[0];
        rmax[n-1] = arr[n-1];
        for(int i=1; i<n; i++){
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }
        for(int i=n-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }
        for(int i=1; i<n-1; i++){
            res += Math.min(lmax[i], rmax[i]) - arr[i];
        }
        return res;
    }
}