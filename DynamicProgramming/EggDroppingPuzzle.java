/**
 * EggDroppingPuzzle
 */
public class EggDroppingPuzzle {
    public static void main(String[] args) {
        int floors = 10;
        int eggs = 2;

        // System.out.println(resRecursive(floors, eggs));
        System.out.println(resDP(floors, eggs));
    }

    // Simple recursive solution
    public static int resRecursive(int floors, int eggs){
        if(eggs==1) return floors;
        if(floors==1) return 1;
        if(floors==0) return 0;

        int res = 0, min=Integer.MAX_VALUE;
        for(int i=1; i<=floors; i++){
            res =  Math.max(resRecursive(i-1, eggs-1), resRecursive(floors-i, eggs));
            if(res<min){
                min = res;
            }
        }
        return min+1;

    }

    // DP Solution
    public static int resDP(int floors, int eggs){
        int dp[][] = new int[floors+1][eggs+1];
        for(int i=0; i<=floors; i++){
            dp[i][1] = i;
        }
        for(int i=0; i<=eggs; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=floors; i++){
            for(int j=2; j<=eggs; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1; x<=i; x++){
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x-1][j-1], dp[i-x][j]));
                }
            }
        }
        return dp[floors][eggs];
    }
}