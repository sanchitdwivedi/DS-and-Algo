package Arrays;

import java.io.*;

public class Leaders {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        printLeaders(arr);
    }

    public static void printLeaders(int[] arr){
        int n = arr.length;
        int curr_leader = arr[n-1];
        System.out.println(curr_leader);
        for(int i=n-2; i>=0; i--){
            if(arr[i]>curr_leader){
                System.out.println(arr[i]);
                curr_leader = arr[i];
            }
        }
    }
}
