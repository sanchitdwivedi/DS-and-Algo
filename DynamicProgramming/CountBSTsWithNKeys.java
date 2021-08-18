public class CountBSTsWithNKeys {
    public static void main(String[] args) {
        int n = 5;
        // System.out.println(countBSTsRecursive(n));
        System.out.println(countBSTs(n));
    }

    // Simple recursion
    public static int countBSTsRecursive(int n){
        if(n==0) return 1;
        int res = 0;
        for(int i=0; i<n; i++){
            res += countBSTsRecursive(i)*countBSTsRecursive(n-i-1);
        } 
        return res;
    }

    // DP solution
    public static int countBSTs(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
