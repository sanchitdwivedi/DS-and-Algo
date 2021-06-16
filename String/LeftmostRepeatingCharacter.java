import java.util.Arrays;

/**
 * LeftmostRepeatingCharacter
 */
public class LeftmostRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abccbd";
        System.out.println(leftMost(str));
    }

    public static int leftMost(String str){
        int leftIndex[] = new int[256];
        Arrays.fill(leftIndex, -1);
        int res = Integer.MAX_VALUE;
        for(int i=0; i<str.length(); i++){
            int fi = leftIndex[str.charAt(i)];
            if(fi==-1){
                leftIndex[str.charAt(i)] = i;
            }
            else{
                res = Math.min(res, fi);
            }
        }
        return res==Integer.MAX_VALUE ? -1: res;
    }
}