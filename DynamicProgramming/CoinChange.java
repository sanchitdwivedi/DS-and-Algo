/**
 * CoinChange
 */
public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {2, 3, 5, 6};
        int sum = 10;

        // System.out.println(getCountRecursive(coins, sum, coins.length));
        System.out.println(getCountDP(coins, sum, coins.length));
    }

    // Simple Recursive
    public static int getCountRecursive(int[] coins, int sum, int n){
        if(sum==0) return 1;
        if(n==0) return 0;

        int res = getCountRecursive(coins, sum, n-1);
        if(coins[n-1]<=sum){
            res += getCountRecursive(coins, sum-coins[n-1], n);
        }
        return res;
    }

    // Tabular DP
    public static int getCountDP(int[] coins, int sum, int n){
        int dp[][] = new int[sum+1][n+1];
        for(int i=0; i<=n; i++){
            dp[0][i] = 1;
        }
        for(int i=0; i<=sum; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=sum; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i][j-1];
                if(coins[j-1]<=i){
                    dp[i][j] += dp[i-coins[j-1]][j];
                }
            }
        }
        return dp[sum][n];
    }
}