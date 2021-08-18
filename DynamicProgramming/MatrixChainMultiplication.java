public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4};
        // System.out.println(minMultRecursive(arr, 0, arr.length-1));
        System.out.println(minMult(arr, arr.length));
    }

    // Simple recursion
    public static int minMultRecursive(int arr[], int i, int j){
        if(i+1==j) return 0;
        int res = Integer.MAX_VALUE;
        for(int k=i+1; k<j; k++){
            res = Math.min(res, minMultRecursive(arr, i, k)+minMultRecursive(arr, k, j)+arr[i]*arr[j]*arr[k]);
        }
        return res;
    }

    // DP solution
    public static int minMult(int arr[], int n){
        int dp[][] = new int[n][n];
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = 0;
        }
        for(int gap=2; gap<n; gap++){
            for(int i=0; i+gap<n; i++){
                int j = i+gap;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
