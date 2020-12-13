package Arrays;

import java.io.*;

/**
 * MinGroupFlipsToMakeSame
 */
public class MinGroupFlipsToMakeSame {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        minFlips(arr, n);
    }

    public static void minFlips(int arr[], int n) {
        for(int i=1; i<n; i++){
            if(arr[i]!=arr[i-1]){
                if(arr[i]!=arr[0]){
                    System.out.print("From "+i+" to ");
                }
                else{
                    System.out.println(i);
                }
            }
        }
        if(arr[n-1]!=arr[0]){
            System.out.println(n-1);
        }
    }
}