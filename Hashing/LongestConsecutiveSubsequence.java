import java.util.HashSet;

/**
 * find longest subsequence which is consecutive i.e x, x+1, x+2, x+3... so on
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int arr[] = {1, 3, 9, 2, 8, 2};
        System.out.println(findLongestSubsequence(arr, arr.length));
    }

    public static int findLongestSubsequence(int arr[], int n){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }
        int res=0;
        for(Integer s: set){
            if(!set.contains(s-1)){
                int curr=1;
                while(set.contains(s+curr)){
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
