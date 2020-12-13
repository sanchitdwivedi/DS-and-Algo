package Arrays;

import java.io.*;

// an element which have same sum of elemetns before and after it is known as equilibrium point ==> Prefix sum
public class EqulibriumPoint {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(eqPoint(arr, n));
    }

    public static boolean eqPoint(int arr[], int n) {
        int sum=0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        int l_sum = 0;
        for(int i=0; i<n; i++){
            if(l_sum == sum-arr[i]){
                return true;
            }
            l_sum += arr[i];
            sum -= arr[i];
        }
        return false;
    }
}
