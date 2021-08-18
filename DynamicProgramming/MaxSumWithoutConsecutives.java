public class MaxSumWithoutConsecutives {
    public static void main(String[] args) {
        int arr[] = {10, 5, 15, 20};
        // System.out.println(maxSumRecursive(arr, arr.length));
        System.out.println(maxSumDP(arr, arr.length));
    }

    // Simple recursion
    public static int maxSumRecursive(int arr[], int n){
        if(n==0) return 0;
        if(n==1) return arr[n-1];
        if(n==2){
            return Math.max(arr[n-1], arr[n-2]);
        }
        return Math.max(maxSumRecursive(arr, n-2)+arr[n-1], maxSumRecursive(arr, n-1));
    }

    // DP solution
    public static int maxSumDP(int arr[], int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = arr[0];
        for(int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i-2]+arr[i-1], dp[i-1]);
        }
        return dp[n];
    }
}
