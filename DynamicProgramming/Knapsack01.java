public class Knapsack01 {
    public static void main(String[] args) {
        int val[] = {10, 40, 30, 50};
        int w[] = {5, 4, 6, 3};
        int W = 10;

        // System.out.println(maxProfitRecursive(val, w, W, 0));
        System.out.println(maxProfit(val, w, W));
    }

    // Simple recursion
    public static int maxProfitRecursive(int val[] , int w[], int W, int i){
        if(W==0) return 0;
        if(i==w.length) return 0;
        if(w[i]<=W){
            return Math.max(val[i] + maxProfitRecursive(val, w, W-w[i], i+1), maxProfitRecursive(val, w, W, i+1));
        }
        else{
            return maxProfitRecursive(val, w, W, i+1);
        }
    }

    // DP solution
    public static int maxProfit(int val[] , int w[], int W){
        int dp[][] = new int[w.length+1][W+1];
        for(int i=1; i<=w.length; i++){
            for(int j=1; j<=W; j++){
                if(w[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j-w[i-1]]+val[i-1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[w.length][W];
    }
}
