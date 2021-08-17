public class OptimalStrategyGame {
    public static void main(String[] args) {
        int arr[] = {20, 5, 4, 6};
        // System.out.println(solRecursive(arr, 0, arr.length-1));
        System.out.println(solDP(arr, arr.length));
    }

    // Simple recursion
    public static int solRecursive(int arr[], int i, int j){

        if(i+1==j){
            return Math.max(arr[i], arr[j]);
        }
        return Math.max(arr[i]+Math.min(solRecursive(arr, i+2, j), solRecursive(arr, i+1, j-1)), arr[j]+Math.min(solRecursive(arr, i, j-2), solRecursive(arr, i+1, j-1)));

    }

    // DP solution
    public static int solDP(int arr[], int n){
        int dp[][] = new int[n][n];
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = Math.max(arr[i], arr[i+1]);
        }
        for(int gap=3; gap<n; gap+=2){
            for(int i=0; i+gap<n; i++){
                int j = i+gap;
                dp[i][j] = Math.max(arr[i]+Math.min(dp[i+2][j], dp[i+1][j-1]), arr[j]+Math.min(dp[i][j-2], dp[i+1][j-1]));
            }
        }
        return dp[0][n-1];
    }
}
