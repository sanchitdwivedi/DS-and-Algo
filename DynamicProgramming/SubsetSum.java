public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 3, 6};
        int sum = 8;
        // System.out.println(subsetCountRecursive(arr, sum, arr.length));
        System.out.println(subsetCount(arr, sum, arr.length));
    }

    // Simple recursion
    public static int subsetCountRecursive(int arr[], int sum, int n){
        if(sum==0) return 1;
        if(n==0) return 0;
        if(sum>=arr[n-1]){
            return subsetCount(arr, sum-arr[n-1], n-1) + subsetCount(arr, sum, n-1);
        }
        else{
            return subsetCount(arr, sum, n-1);
        }
    }

    // DP solution
    public static int subsetCount(int arr[], int sum, int n){
        int dp[][] = new int[n+1][sum+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
