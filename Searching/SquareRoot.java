package Searching;

import java.io.*;

/**
 * SquareRoot
 */
public class SquareRoot {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(sqRoot(x));
    }

    public static int sqRoot (int x) {
        int low = 1, high = x, mid=0, ans=-1;
        while(low<=high){
            mid = (low+high)/2;
            if(mid*mid == x){
                ans = mid;
                return ans;
            }
            else if (mid*mid < x){
                low = mid+1;
                ans = mid;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }
}