public class MaxCuts {
    public static void main(String[] args) {
        int n=5, a=1, b=2, c=3;
        // System.out.println(maxCutsRecursive(n, a, b, c));
        System.out.println(maxCutsDP(n, a, b, c));
    }

    // Simple recursive solution => O(3^n)
    public static int maxCutsRecursive(int n, int a, int b, int c){
        if(n<0) return -1;
        if(n==0) return 0;
        int res = Math.max(maxCutsRecursive(n-a, a, b, c), Math.max(maxCutsRecursive(n-b, a, b, c), maxCutsRecursive(n-c, a, b, c)));
        if(res==-1) return res;
        else return res+1;
    }

    // DP solution => O(n)
    public static int maxCutsDP(int n, int a, int b, int c){
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = -1;
            if(i-a>=0){
                dp[i] = Math.max(dp[i], dp[i-a]);
            }
            if(i-b>=0){
                dp[i] = Math.max(dp[i], dp[i-b]);
            }
            if(i-c>=0){
                dp[i] = Math.max(dp[i], dp[i-c]);
            }
            if(dp[i]!=-1) dp[i]++;
        }
        return dp[n];
    }
}
