import java.util.*;

public class MinCoins {
    public static void main(String[] args) {
        int arr[] = {9, 6, 5, 1};
        int sum = 11;

        // System.out.println(countCoins(arr, sum, arr.length));
        System.out.println(countCoinsDP(arr, sum, arr.length));
    }

    // Simple recursion
    public static int countCoins(int arr[], int sum, int n){
        if(sum==0) return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i]<=sum){    
                int sub_res = countCoins(arr, sum-arr[i], n);
                if(sub_res!=Integer.MAX_VALUE){
                    res = Math.min(res, sub_res+1);
                }
            }
        }
        return res;
    }

    // DP solution
    public static int countCoinsDP(int arr[], int sum, int n){
        int dp[] = new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=sum; i++){
            for(int j=0; j<n; j++){
                if(arr[j]<=i){
                    int sub_res = dp[i-arr[j]];
                    if(sub_res!=Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], sub_res+1);
                    }
                }
            }
        }
        return dp[sum];
    }
}
