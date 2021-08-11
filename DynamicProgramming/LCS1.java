import java.util.*;

public class LCS1 {
    static int[][] dp;
    public static void main(String[] args) {
        String s1= "AXYZ";
        String s2 = "BAZ";

        // int res = recursive(s1, s2, s1.length(), s2.length());
        dp = new int[s1.length()+1][s2.length()+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        // int res = memo(s1, s2, s1.length(), s2.length());
        int res = tabular(s1, s2, s1.length(), s2.length());
        System.out.println(res);
    }

    // Simple recursive solution => O(2^n)
    public static int recursive(String s1, String s2, int n, int m){
        if(n==0 || m==0) return 0;
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return 1+recursive(s1, s2, n-1, m-1);
        }
        return Math.max(recursive(s1, s2, n-1, m), recursive(s1, s2, n, m-1));
    }

    // Memoization (Top-down) solution => O(m*n)
    public static int memo(String s1, String s2, int n, int m){
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(n==0 || m==0){
            dp[n][m] = 0;
        }
        else if(s1.charAt(n-1)==s2.charAt(m-1)){
            dp[n][m] =  1+memo(s1, s2, n-1, m-1);
        }
        else{
            dp[n][m] = Math.max(memo(s1, s2, n-1, m), memo(s1, s2, n, m-1));
        }
        return dp[n][m];
    }

    // Tabular (Bottom-up) solution => O(n*m)
    public static int tabular(String s1, String s2, int n, int m){
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=m; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
