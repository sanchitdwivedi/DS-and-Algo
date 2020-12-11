package Arrays;

import java.io.*;

public class StockBuyAndSell {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(maxProfit(arr, n));
    }

    public static int maxProfit(int[] arr, int n){
        int profit=0;
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){
                profit += arr[i]-arr[i-1];
            }
        }
        return profit;
    }
}
