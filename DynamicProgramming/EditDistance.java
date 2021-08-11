/**
 * Make both strings equal using these 3 operations:-
 * Insert, Delete, Replace
 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "SUNDAY";
        String s2 = "SATURDAY";

        // System.out.println(eDRecursive(s1, s2, s1.length(), s2.length()));
        System.out.println(eDTabular(s1, s2, s1.length(), s2.length()));
    }

    // Simple recursion
    public static int eDRecursive(String s1, String s2, int n, int m){
        if(n==0) return m;
        if(m==0) return n;
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return eDRecursive(s1, s2, n-1, m-1);
        }
        else{
            return 1 + Math.min(eDRecursive(s1, s2, n, m-1), Math.min(eDRecursive(s1, s2, n-1, m), eDRecursive(s1, s2, n-1, m-1)));
        }
    }

    // Tabular DP
    public static int eDTabular(String s1, String s2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int i=0; i<=m; i++){
            dp[0][i] = i;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}
