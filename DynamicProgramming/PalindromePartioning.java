public class PalindromePartioning {
    public static void main(String[] args) {
        String s = "geek";
        // System.out.println(minPartiotionsRecursive(s, 0, s.length()-1));
        System.out.println(minPartitions(s, s.length()));
    }

    // Simple recursion
    public static int minPartiotionsRecursive(String s, int i, int j){
        if(isPalindrome(s, i, j)) return 0;
        int res = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            res = Math.min(res, 1 + minPartiotionsRecursive(s, i, k) + minPartiotionsRecursive(s, k+1, j));
        }
        return res;
    }

    public static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // DP solution
    public static int minPartitions(String s, int n){
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i]= 0;
        }
        for(int gap=1; gap<n; gap++){
            for(int i=0; i+gap<n; i++){
                int j = i+gap;
                if(isPalindrome(s, i, j)){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
