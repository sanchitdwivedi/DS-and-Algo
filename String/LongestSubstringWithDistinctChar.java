import java.util.Arrays;

public class LongestSubstringWithDistinctChar {
    public static void main(String[] args) {
        String str = "abcadbd";
        System.out.println(longestDistinct(str));
    }

    public static int longestDistinct(String str){
        int n = str.length();
        int prev[] = new int[256];
        Arrays.fill(prev, -1);
        int start = 0, res=0;
        for(int i=0; i<n; i++){
            start = Math.max(start, prev[str.charAt(i)]+1);
            res = Math.max(res, i-start+1);
            prev[str.charAt(i)] = i;
        }
        return res;
    }
}
