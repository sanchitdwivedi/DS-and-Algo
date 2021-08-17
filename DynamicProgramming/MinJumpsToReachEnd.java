import java.util.Arrays;

/**
 * MinJumpsToReachEnd
 */
public class MinJumpsToReachEnd {
    public static void main(String[] args) {
        int arr[]  = {3, 4, 2, 1, 2, 1};
        // System.out.println(minJumpsRecursive(arr, arr.length));
        System.out.println(minJumps(arr, arr.length));
    }

    // Simple recursive solution
    public static int minJumpsRecursive(int arr[] , int n){
        if(n==1) return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<=n-2; i++){
            if(i+arr[i]>=n-1){
                int sub_res = minJumpsRecursive(arr, i+1);
                if(sub_res!=Integer.MAX_VALUE){
                    res = Math.min(res, sub_res+1);
                }
            }
        }
        return res;
    }

    // DP solution
    public static int minJumps(int arr[], int n){
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(j+arr[j]>=i){
                    if(dp[j]!=Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], dp[j]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}