/**
 * AllocateMinPages
 */
public class AllocateMinPages {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        int k = 2;
        // System.out.println(minpagesRecursive(arr, arr.length, k));
        System.out.println(minPagesDP(arr, arr.length, k));
    }

    // Simple recursion
    public static int minpagesRecursive(int arr[], int n, int k){
        if(k==1) return sum(arr, 0, n-1);
        if(n==1) return arr[0];
        int res = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            res = Math.min(res, Math.max(minpagesRecursive(arr, i, k-1), sum(arr, i, n-1)));
        }
        return res;
    }

    public static int sum(int arr[], int i, int j){
        int res = 0;
        for(int k = i;k<=j; k++){
            res += arr[k];
        }
        return res;
    }

    // DP solution
    public static int minPagesDP(int arr[], int n, int k){
        int dp[][] = new int[n+1][k+1];
        for(int i=1; i<=k; i++){
            dp[1][i] = arr[0];
        }
        for(int i=1; i<=n; i++){
            dp[i][1] = sum(arr, 0, i-1);
        }
        for(int i=2; i<=n; i++){
            for(int j=2; j<=k; j++){
                int res = Integer.MAX_VALUE;
                for(int p=1; p<i; p++){
                    res = Math.min(res, Math.max(dp[p][j-1], sum(arr, p, i-1)));
                }
                dp[i][j] = res;
            }
        }
        return dp[n][k];
    }
}