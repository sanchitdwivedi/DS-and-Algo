package BitMagic;

import java.io.*;

public class TwoOddOcurring {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        oddAppearing(arr, n);
    }

    public static void oddAppearing(int[] arr, int n){
        int xor = 0, res1 = 0, res2 = 0;
        for(int i=0; i<n; i++){
            xor = xor^arr[i];
        }
        int last_set_bit = xor & ~(xor-1);
        for(int i=0; i<n; i++){
            if((last_set_bit & arr[i]) != 0){
                res1 = res1 ^ arr[i];
            }
            else{
                res2 = res2 ^arr[i];
            }
        }
        System.out.println(res1 + " " + res2);
    }
}
